package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import java.util.ArrayList;
import java.util.List;

public class WeChatBrands
{
  public static final String TAG = "MicroMsg.WeChatBrands";
  
  public static void update(int paramInt)
  {
    AppMethodBeat.i(249057);
    int i = paramInt;
    if (paramInt == 0) {
      i = WeChatBrands.AppInfo.current().getDefaultXAgreementId();
    }
    WeChatBrands.UserInfo.xagreementId = i;
    updateEnableAutoSeparate();
    AppMethodBeat.o(249057);
  }
  
  public static void updateBizRestrictAlertHandler(androidx.a.a.c.a<WeChatBrands.Business.Entries, Boolean> parama)
  {
    Business.sAlertHandler = parama;
  }
  
  public static void updateBizRestrictAlertSupplier(WeChatBrands.Business.AvailabilityAlertSupplier paramAvailabilityAlertSupplier)
  {
    Business.sAlertSupplier = paramAvailabilityAlertSupplier;
  }
  
  public static void updateBizRestrictHandler(androidx.a.a.c.a<WeChatBrands.Business.Entries, Boolean> parama)
  {
    Business.sRestrictHanlder = parama;
  }
  
  private static void updateEnableAutoSeparate()
  {
    AppMethodBeat.i(249062);
    if (("HK".equals(WeChatBrands.AppInfo.lang)) || ("TW".equals(WeChatBrands.AppInfo.lang)))
    {
      Wordings.access$102(true);
      AppMethodBeat.o(249062);
      return;
    }
    Wordings.access$102(false);
    AppMethodBeat.o(249062);
  }
  
  public static void updateLang(String paramString)
  {
    AppMethodBeat.i(249058);
    WeChatBrands.AppInfo.lang = WeChatBrands.AppInfo.getBrandLang(paramString);
    updateEnableAutoSeparate();
    if (Wordings.handler.mReplacer != null) {
      Wordings.handler.mReplacer.reload();
    }
    AppMethodBeat.o(249058);
  }
  
  public static void updateReplacer(IReplaceApply<String, String> paramIReplaceApply)
  {
    AppMethodBeat.i(249060);
    Wordings.handler.attachReplacer(paramIReplaceApply);
    AppMethodBeat.o(249060);
  }
  
  public static class Business
  {
    public static final String GROUP_ADS = "ads";
    public static final String GROUP_CHANNELS = "channels";
    public static final String GROUP_CROSS_DATA = "cross_data";
    public static final String GROUP_LIVE = "live";
    public static final String GROUP_MP = "mp";
    public static final String GROUP_OA = "oa";
    public static final String GROUP_OPEN = "open";
    public static final String GROUP_PAY = "pay";
    public static final String GROUP_SEARCH = "search";
    public static final String GROUP_SECONDARY = "secondary";
    public static final String GROUP_THIRD_PARTY = "third_party";
    public static final String GROUP_WECHAT_OUT = "wechat_out";
    public static final String GROUP_WECOM = "wecom";
    public static final int STATUS_O = 0;
    public static final int STATUS_R = 2;
    public static final int STATUS_X = 1;
    static androidx.a.a.c.a<WeChatBrands.Business.Entries, Boolean> sAlertHandler;
    static AvailabilityAlertSupplier sAlertSupplier;
    static androidx.a.a.c.a<WeChatBrands.Business.Entries, Boolean> sRestrictHanlder;
    
    static
    {
      AppMethodBeat.i(249170);
      sRestrictHanlder = new androidx.a.a.c.a()
      {
        public final Boolean apply(WeChatBrands.Business.Entries paramAnonymousEntries)
        {
          AppMethodBeat.i(249121);
          boolean bool = paramAnonymousEntries.restricted();
          AppMethodBeat.o(249121);
          return Boolean.valueOf(bool);
        }
      };
      sAlertHandler = new androidx.a.a.c.a()
      {
        public final Boolean apply(WeChatBrands.Business.Entries paramAnonymousEntries)
        {
          AppMethodBeat.i(248836);
          boolean bool = paramAnonymousEntries.signRequsted();
          AppMethodBeat.o(248836);
          return Boolean.valueOf(bool);
        }
      };
      sAlertSupplier = new AvailabilityAlertSupplier();
      AppMethodBeat.o(249170);
    }
    
    public static class AvailabilityAlertSupplier
    {
      public static final int ON_DISMISS = -1;
      public static final int ON_NO = 0;
      public static final int ON_YES = 1;
      protected String mBody;
      protected androidx.core.f.a<Integer> mCallback;
      protected String mNegativeBtnText;
      protected DialogInterface.OnClickListener mOnDismissListener;
      protected DialogInterface.OnClickListener mOnNegativeClickListener;
      protected DialogInterface.OnClickListener mOnPositiveClickListener;
      protected String mPositiveBtnText;
      protected String mTilte;
      
      public AvailabilityAlertSupplier attach(androidx.core.f.a<Integer> parama)
      {
        this.mCallback = parama;
        return this;
      }
      
      public String getBody()
      {
        return this.mBody;
      }
      
      public androidx.core.f.a<Integer> getCallback()
      {
        return this.mCallback;
      }
      
      public String getNegativeBtnText()
      {
        return this.mNegativeBtnText;
      }
      
      public DialogInterface.OnClickListener getOnDismissListener()
      {
        return this.mOnDismissListener;
      }
      
      public DialogInterface.OnClickListener getOnNegativeClickListener()
      {
        return this.mOnNegativeClickListener;
      }
      
      public DialogInterface.OnClickListener getOnPositiveClickListener()
      {
        return this.mOnPositiveClickListener;
      }
      
      public String getPositiveBtnText()
      {
        return this.mPositiveBtnText;
      }
      
      public String getTilte()
      {
        return this.mTilte;
      }
      
      public AvailabilityAlertSupplier setBody(String paramString)
      {
        this.mBody = paramString;
        return this;
      }
      
      public AvailabilityAlertSupplier setNegativeBtnText(String paramString)
      {
        this.mNegativeBtnText = paramString;
        return this;
      }
      
      public AvailabilityAlertSupplier setOnDismissListener(DialogInterface.OnClickListener paramOnClickListener)
      {
        this.mOnDismissListener = paramOnClickListener;
        return this;
      }
      
      public AvailabilityAlertSupplier setOnNegativeClickListener(DialogInterface.OnClickListener paramOnClickListener)
      {
        this.mOnNegativeClickListener = paramOnClickListener;
        return this;
      }
      
      public AvailabilityAlertSupplier setOnPositiveClickListener(DialogInterface.OnClickListener paramOnClickListener)
      {
        this.mOnPositiveClickListener = paramOnClickListener;
        return this;
      }
      
      public AvailabilityAlertSupplier setPositiveBtnText(String paramString)
      {
        this.mPositiveBtnText = paramString;
        return this;
      }
      
      public AvailabilityAlertSupplier setTilte(String paramString)
      {
        this.mTilte = paramString;
        return this;
      }
      
      public void showDialog(Context paramContext) {}
    }
  }
  
  public static abstract interface IReplaceApply<I, O>
  {
    public abstract O apply(I paramI, PInt paramPInt);
    
    public abstract void reload();
  }
  
  public static class PlaceHolderHandler
  {
    private static final String SYMBOL_END = "}";
    private static final int SYMBOL_END_LEN = 1;
    private static final String SYMBOL_STR = "${";
    private static final int SYMBOL_STR_LEN = 2;
    androidx.a.a.c.a<List, String> mJoiner;
    WeChatBrands.IReplaceApply<String, String> mReplacer;
    
    public PlaceHolderHandler()
    {
      AppMethodBeat.i(249140);
      this.mReplacer = new WeChatBrands.IReplaceApply()
      {
        public String apply(String paramAnonymousString, PInt paramAnonymousPInt)
        {
          return paramAnonymousString;
        }
        
        public void reload() {}
      };
      this.mJoiner = new WeChatBrands.PlaceHolderHandler.2(this);
      AppMethodBeat.o(249140);
    }
    
    private static Object computePlaceHolders(String paramString, WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
    {
      AppMethodBeat.i(249144);
      try
      {
        paramIReplaceApply = iterateComputingPlaceHolders(paramString, paramIReplaceApply);
        AppMethodBeat.o(249144);
        return paramIReplaceApply;
      }
      catch (Throwable paramIReplaceApply)
      {
        Log.printErrStackTrace("MicroMsg.WeChatBrands", paramIReplaceApply, "compute place holders error: " + paramIReplaceApply.getMessage() + ", input = " + paramString, new Object[0]);
        AppMethodBeat.o(249144);
      }
      return paramString;
    }
    
    private static Object iterateComputingPlaceHolders(String paramString, WeChatBrands.IReplaceApply<String, String> paramIReplaceApply)
    {
      AppMethodBeat.i(249145);
      int i = paramString.indexOf("${");
      if (i < 0)
      {
        AppMethodBeat.o(249145);
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
            AppMethodBeat.o(249145);
            return localArrayList;
          }
          int j = paramString.indexOf("}");
          if ((j < 0) || (SYMBOL_STR_LEN + i >= paramString.length() - 1))
          {
            localArrayList.add(paramString);
            AppMethodBeat.o(249145);
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
              AppMethodBeat.o(249145);
              return localArrayList;
            }
            paramString = paramString.substring(SYMBOL_END_LEN + j);
            i = paramString.indexOf("${");
          }
        }
      }
    }
    
    public PlaceHolderHandler attachJoiner(androidx.a.a.c.a<List, String> parama)
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
      AppMethodBeat.i(249142);
      if (paramString == null)
      {
        AppMethodBeat.o(249142);
        return null;
      }
      if (paramString.length() == 0)
      {
        AppMethodBeat.o(249142);
        return "";
      }
      paramString = computePlaceHolders(paramString, this.mReplacer);
      if ((paramString instanceof String))
      {
        paramString = (String)paramString;
        AppMethodBeat.o(249142);
        return paramString;
      }
      paramString = (String)this.mJoiner.apply((List)paramString);
      AppMethodBeat.o(249142);
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
        AppMethodBeat.i(249008);
        if (this.mReplacer == null)
        {
          localObject = String.valueOf(this.mText);
          AppMethodBeat.o(249008);
          return localObject;
        }
        Object localObject = new PInt();
        String str = (String)this.mReplacer.apply(this.mText, (PInt)localObject);
        if (((PInt)localObject).value == 1) {}
        for (;;)
        {
          this.mIsDomainReplace = bool;
          AppMethodBeat.o(249008);
          return str;
          bool = false;
        }
      }
    }
  }
  
  public static class Wordings
  {
    private static final char SYMBOL_LINEFEED = '\n';
    private static final char SYMBOL_SEPARATOR = ' ';
    private static final WeChatBrands.PlaceHolderHandler handler;
    private static boolean sEnableAutoSeparate;
    
    static
    {
      AppMethodBeat.i(248801);
      handler = new WeChatBrands.PlaceHolderHandler();
      sEnableAutoSeparate = false;
      handler.attachJoiner(new androidx.a.a.c.a()
      {
        public final String apply(List paramAnonymousList)
        {
          AppMethodBeat.i(248851);
          StringBuilder localStringBuilder = new StringBuilder();
          int i = 0;
          Object localObject1 = null;
          String str;
          if (i < paramAnonymousList.size())
          {
            Object localObject2 = paramAnonymousList.get(i);
            str = localObject2.toString();
            if (TextUtils.isEmpty(str)) {
              break label185;
            }
            if (((localObject2 instanceof WeChatBrands.PlaceHolderHandler.PlaceHolderSpan)) && (WeChatBrands.Wordings.sEnableAutoSeparate) && (!((WeChatBrands.PlaceHolderHandler.PlaceHolderSpan)localObject2).mIsDomainReplace))
            {
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (WeChatBrands.Wordings.access$200((String)localObject1, str))) {
                localStringBuilder.append(' ');
              }
              localStringBuilder.append(str);
              if ((i < paramAnonymousList.size() - 1) && (WeChatBrands.Wordings.access$200(str, paramAnonymousList.get(i + 1).toString()))) {
                localStringBuilder.append(' ');
              }
              localObject1 = null;
            }
          }
          label185:
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append(str);
            localObject1 = str;
            continue;
            paramAnonymousList = localStringBuilder.toString();
            AppMethodBeat.o(248851);
            return paramAnonymousList;
          }
        }
      });
      AppMethodBeat.o(248801);
    }
    
    private static boolean isAlphabet(char paramChar)
    {
      return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
    }
    
    private static boolean isChineseMarks(char paramChar)
    {
      return (paramChar == 65292) || (paramChar == '。') || (paramChar == 65281) || (paramChar == 65311) || (paramChar == 65306) || (paramChar == 65307) || (paramChar == '、') || (paramChar == '「') || (paramChar == '」');
    }
    
    private static boolean isEnMarks(char paramChar)
    {
      return (paramChar == '.') || (paramChar == ',') || (paramChar == '?') || (paramChar == '!') || (paramChar == ';') || (paramChar == ':');
    }
    
    private static boolean isLeftLinefeed(String paramString)
    {
      AppMethodBeat.i(248797);
      if ((paramString.charAt(paramString.length() - 1) == 'n') && (paramString.length() > 1) && (paramString.charAt(paramString.length() - 2) == '\\'))
      {
        AppMethodBeat.o(248797);
        return true;
      }
      AppMethodBeat.o(248797);
      return false;
    }
    
    private static boolean isLeftXmlFormat(String paramString)
    {
      AppMethodBeat.i(248798);
      if ((paramString.charAt(paramString.length() - 1) == 's') && (paramString.length() > 1) && (paramString.charAt(paramString.length() - 2) == '%'))
      {
        AppMethodBeat.o(248798);
        return true;
      }
      AppMethodBeat.o(248798);
      return false;
    }
    
    private static boolean notSeparateChar(char paramChar)
    {
      return (paramChar == '-') || (paramChar == '/') || (paramChar == '\\');
    }
    
    private static boolean shouldSeparate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(248795);
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      {
        AppMethodBeat.o(248795);
        return false;
      }
      char c1 = paramString1.charAt(paramString1.length() - 1);
      char c2 = paramString2.charAt(0);
      if ((c1 == ' ') || (c2 == ' ') || (c1 == '\n') || (c2 == '\n'))
      {
        AppMethodBeat.o(248795);
        return false;
      }
      if ((isChineseMarks(c1)) || (isChineseMarks(c2)))
      {
        AppMethodBeat.o(248795);
        return false;
      }
      if ((notSeparateChar(c1)) || (notSeparateChar(c2)))
      {
        AppMethodBeat.o(248795);
        return false;
      }
      if (isEnMarks(c2))
      {
        AppMethodBeat.o(248795);
        return false;
      }
      if (isEnMarks(c1))
      {
        AppMethodBeat.o(248795);
        return true;
      }
      if ((isAlphabet(c1)) || (Character.isDigit(c1)))
      {
        if (isLeftLinefeed(paramString1))
        {
          AppMethodBeat.o(248795);
          return false;
        }
        if ((isLeftXmlFormat(paramString1)) && (!isAlphabet(c2)))
        {
          AppMethodBeat.o(248795);
          return false;
        }
        AppMethodBeat.o(248795);
        return true;
      }
      if ((isAlphabet(c2)) || (Character.isDigit(c2)))
      {
        AppMethodBeat.o(248795);
        return true;
      }
      AppMethodBeat.o(248795);
      return false;
    }
    
    public static String translate(String paramString)
    {
      AppMethodBeat.i(248794);
      paramString = handler.replace(paramString);
      AppMethodBeat.o(248794);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands
 * JD-Core Version:    0.7.0.1
 */