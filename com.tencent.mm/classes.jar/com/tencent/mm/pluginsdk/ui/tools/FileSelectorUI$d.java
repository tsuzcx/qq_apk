package com.tencent.mm.pluginsdk.ui.tools;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.R.l;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "DEFAULT_PAGESIZE", "", "getDEFAULT_PAGESIZE", "()I", "setDEFAULT_PAGESIZE", "(I)V", "getAdapter", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "fileList", "", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "getFileList", "()Ljava/util/List;", "setFileList", "(Ljava/util/List;)V", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "searchList", "startIndex", "getStartIndex", "setStartIndex", "talker", "", "getTalker", "()Ljava/lang/String;", "setTalker", "(Ljava/lang/String;)V", "getData", "getDisplayName", "fromUser", "getHighLightContent", "", "key", "content", "initASync", "", "loadMoreAsync", "search", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FileSelectorUI$d
{
  final FileSelectorUI.e YrI;
  private int YrV;
  List<FileSelectorUI.j> YrW;
  private List<FileSelectorUI.j> YrX;
  boolean hasInit;
  private int startIndex;
  private String talker;
  
  public FileSelectorUI$d(FileSelectorUI.e parame)
  {
    this.YrI = localObject;
    this.YrV = 100;
    parame = Collections.synchronizedList((List)new ArrayList());
    s.s(parame, "synchronizedList(ArrayList<ListFileItem>())");
    this.YrW = parame;
    parame = Collections.synchronizedList((List)new ArrayList());
    s.s(parame, "synchronizedList(ArrayList<ListFileItem>())");
    this.YrX = parame;
    parame = z.bAM();
    s.s(parame, "getUsernameFromUserInfo()");
    this.talker = parame;
  }
  
  private static CharSequence b(String paramString, CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    int i = n.a(paramCharSequence, paramString, 0, true);
    localSpannableString.setSpan(new ForegroundColorSpan(b.b.HwL), i, paramString.length() + i, 33);
    localSpannableStringBuilder.append((CharSequence)localSpannableString);
    return (CharSequence)localSpannableStringBuilder;
  }
  
  protected final String aJK()
  {
    return this.talker;
  }
  
  protected final void axe(int paramInt)
  {
    this.YrV = paramInt;
  }
  
  public final List<FileSelectorUI.j> brH(String paramString)
  {
    s.u(paramString, "key");
    this.YrX.clear();
    Object localObject;
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.YrW.iterator();
      while (paramString.hasNext())
      {
        localObject = (FileSelectorUI.j)paramString.next();
        ((FileSelectorUI.j)localObject).Ysx = ((CharSequence)String.valueOf(((FileSelectorUI.j)localObject).Ysx));
        ((FileSelectorUI.j)localObject).aO((CharSequence)((FileSelectorUI.j)localObject).iOm().toString());
        localObject = ((FileSelectorUI.j)localObject).iOl();
        this.YrX.add(localObject);
      }
    }
    Iterator localIterator = this.YrW.iterator();
    if (localIterator.hasNext())
    {
      FileSelectorUI.j localj = (FileSelectorUI.j)localIterator.next();
      localObject = localj.Ysx;
      if (localObject == null) {
        localObject = (CharSequence)"";
      }
      for (;;)
      {
        boolean bool1 = n.a(localj.iOm(), (CharSequence)paramString, true);
        boolean bool2 = n.a((CharSequence)localObject, (CharSequence)paramString, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if (bool1) {
          localj.aO(b(paramString, localj.iOm()));
        }
        if (bool2) {
          localj.Ysx = b(paramString, (CharSequence)localObject);
        }
        this.YrX.add(localj);
        break;
      }
    }
    return this.YrX;
  }
  
  protected final String getDisplayName(String paramString)
  {
    String str = z.bAM();
    if ((Util.isNullOrNil(paramString)) || (s.p(paramString, str))) {}
    for (paramString = this.YrS.getString(R.l.gOi);; paramString = aa.getDisplayName(paramString))
    {
      paramString = this.YrS.getString(R.l.gzI, new Object[] { paramString });
      s.s(paramString, "getString(R.string.chatt…ce_from, displayFromUser)");
      return paramString;
    }
  }
  
  protected final int getStartIndex()
  {
    return this.startIndex;
  }
  
  protected final int iOg()
  {
    return this.YrV;
  }
  
  protected final void setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.d
 * JD-Core Version:    0.7.0.1
 */