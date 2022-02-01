package com.tencent.mm.sdk.platformtools;

import androidx.a.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeChatBrands$PlaceHolderHandler
{
  private static final String SYMBOL_END = "}";
  private static final int SYMBOL_END_LEN = 1;
  private static final String SYMBOL_STR = "${";
  private static final int SYMBOL_STR_LEN = 2;
  a<List, String> mJoiner;
  WeChatBrands.IReplaceApply<String, String> mReplacer;
  
  public WeChatBrands$PlaceHolderHandler()
  {
    AppMethodBeat.i(243585);
    this.mReplacer = new WeChatBrands.IReplaceApply()
    {
      public String apply(String paramAnonymousString, PInt paramAnonymousPInt)
      {
        return paramAnonymousString;
      }
      
      public void reload() {}
    };
    this.mJoiner = new a()
    {
      public String apply(List paramAnonymousList)
      {
        AppMethodBeat.i(243560);
        StringBuilder localStringBuilder = new StringBuilder();
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext()) {
          localStringBuilder.append(paramAnonymousList.next().toString());
        }
        paramAnonymousList = localStringBuilder.toString();
        AppMethodBeat.o(243560);
        return paramAnonymousList;
      }
    };
    AppMethodBeat.o(243585);
  }
  
  private static Object computePlaceHolders(String paramString, WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
  {
    AppMethodBeat.i(243589);
    try
    {
      paramIReplaceApply = iterateComputingPlaceHolders(paramString, paramIReplaceApply);
      AppMethodBeat.o(243589);
      return paramIReplaceApply;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.WeChatBrands", paramIReplaceApply, "compute place holders error: " + paramIReplaceApply.getMessage() + ", input = " + paramString, new Object[0]);
      AppMethodBeat.o(243589);
    }
    return paramString;
  }
  
  private static Object iterateComputingPlaceHolders(String paramString, WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
  {
    AppMethodBeat.i(243598);
    int i = paramString.indexOf("${");
    if (i < 0)
    {
      AppMethodBeat.o(243598);
      return paramString;
    }
    ArrayList localArrayList = new ArrayList(5);
    for (;;)
    {
      if (i > 0)
      {
        localArrayList.add(paramString.substring(0, i));
        paramString = paramString.substring(i);
        i = paramString.indexOf("${");
      }
      else
      {
        if (i < 0)
        {
          localArrayList.add(paramString);
          AppMethodBeat.o(243598);
          return localArrayList;
        }
        int j = paramString.indexOf("}");
        if ((j < 0) || (SYMBOL_STR_LEN + i >= paramString.length() - 1))
        {
          localArrayList.add(paramString);
          AppMethodBeat.o(243598);
          return localArrayList;
        }
        if (SYMBOL_STR_LEN + i == j)
        {
          localArrayList.add(paramString.substring(i, j + 1));
          paramString = paramString.substring(j + 1);
          i = paramString.indexOf("${");
        }
        else
        {
          PlaceHolderSpan localPlaceHolderSpan = new PlaceHolderSpan(paramString.substring(i + SYMBOL_STR_LEN, j));
          localPlaceHolderSpan.attach(paramIReplaceApply);
          localArrayList.add(localPlaceHolderSpan);
          if (j == paramString.length() - SYMBOL_END_LEN)
          {
            AppMethodBeat.o(243598);
            return localArrayList;
          }
          paramString = paramString.substring(SYMBOL_END_LEN + j);
          i = paramString.indexOf("${");
        }
      }
    }
  }
  
  public PlaceHolderHandler attachJoiner(a<List, String> parama)
  {
    this.mJoiner = parama;
    return this;
  }
  
  public PlaceHolderHandler attachReplacer(WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
  {
    this.mReplacer = paramIReplaceApply;
    return this;
  }
  
  public String replace(String paramString)
  {
    AppMethodBeat.i(243615);
    if (paramString == null)
    {
      AppMethodBeat.o(243615);
      return null;
    }
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(243615);
      return "";
    }
    paramString = computePlaceHolders(paramString, this.mReplacer);
    if ((paramString instanceof String))
    {
      paramString = (String)paramString;
      AppMethodBeat.o(243615);
      return paramString;
    }
    paramString = (String)this.mJoiner.apply((List)paramString);
    AppMethodBeat.o(243615);
    return paramString;
  }
  
  public static class PlaceHolderSpan
    extends WeChatBrands.PlaceHolderHandler.StringSpan
  {
    public static final int BrandReplacement = 0;
    public static final int DomainReplacement = 1;
    boolean mIsDomainReplace;
    WeChatBrands.IReplaceApply<String, String> mReplacer;
    
    public PlaceHolderSpan(String paramString)
    {
      super();
    }
    
    public PlaceHolderSpan attach(WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
    {
      this.mReplacer = paramIReplaceApply;
      return this;
    }
    
    public boolean isReplaceable()
    {
      return true;
    }
    
    public String toString()
    {
      boolean bool = true;
      AppMethodBeat.i(244061);
      if (this.mReplacer == null)
      {
        localObject = String.valueOf(this.mText);
        AppMethodBeat.o(244061);
        return localObject;
      }
      Object localObject = new PInt();
      String str = (String)this.mReplacer.apply(this.mText, (PInt)localObject);
      if (((PInt)localObject).value == 1) {}
      for (;;)
      {
        this.mIsDomainReplace = bool;
        AppMethodBeat.o(244061);
        return str;
        bool = false;
      }
    }
  }
  
  public static class StringSpan
  {
    protected final String mText;
    
    public StringSpan(String paramString)
    {
      this.mText = paramString;
    }
    
    public boolean isReplaceable()
    {
      return false;
    }
    
    public String toString()
    {
      AppMethodBeat.i(243368);
      String str = String.valueOf(this.mText);
      AppMethodBeat.o(243368);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands.PlaceHolderHandler
 * JD-Core Version:    0.7.0.1
 */