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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "DEFAULT_PAGESIZE", "", "getDEFAULT_PAGESIZE", "()I", "setDEFAULT_PAGESIZE", "(I)V", "getAdapter", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "fileList", "", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "getFileList", "()Ljava/util/List;", "setFileList", "(Ljava/util/List;)V", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "searchList", "startIndex", "getStartIndex", "setStartIndex", "talker", "", "getTalker", "()Ljava/lang/String;", "setTalker", "(Ljava/lang/String;)V", "getData", "getDisplayName", "fromUser", "getHighLightContent", "", "key", "content", "initASync", "", "loadMoreAsync", "search", "app_release"})
public abstract class FileSelectorUI$d
{
  private int RvA;
  List<FileSelectorUI.j> RvB;
  private List<FileSelectorUI.j> RvC;
  final FileSelectorUI.e Rvl;
  boolean hasInit;
  int startIndex;
  private String talker;
  
  public FileSelectorUI$d(FileSelectorUI.e parame)
  {
    this.Rvl = localObject;
    this.RvA = 100;
    parame = Collections.synchronizedList((List)new ArrayList());
    p.j(parame, "Collections.synchronized…rrayList<ListFileItem>())");
    this.RvB = parame;
    parame = Collections.synchronizedList((List)new ArrayList());
    p.j(parame, "Collections.synchronized…rrayList<ListFileItem>())");
    this.RvC = parame;
    parame = z.bcZ();
    p.j(parame, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.talker = parame;
  }
  
  private static CharSequence a(String paramString, CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    int i = n.a(paramCharSequence, paramString, 0, true);
    localSpannableString.setSpan(new ForegroundColorSpan(b.b.BLP), i, paramString.length() + i, 33);
    localSpannableStringBuilder.append((CharSequence)localSpannableString);
    return (CharSequence)localSpannableStringBuilder;
  }
  
  protected final String PJ(String paramString)
  {
    String str = z.bcZ();
    if ((Util.isNullOrNil(paramString)) || (p.h(paramString, str))) {}
    for (paramString = this.Rvw.getString(R.l.eMk);; paramString = aa.PJ(paramString))
    {
      paramString = this.Rvw.getString(R.l.exe, new Object[] { paramString });
      p.j(paramString, "getString(R.string.chatt…ce_from, displayFromUser)");
      return paramString;
    }
  }
  
  protected final String apJ()
  {
    return this.talker;
  }
  
  protected final void aqY(int paramInt)
  {
    this.RvA = paramInt;
  }
  
  public final List<FileSelectorUI.j> brS(String paramString)
  {
    p.k(paramString, "key");
    this.RvC.clear();
    Object localObject;
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.RvB.iterator();
      while (paramString.hasNext())
      {
        localObject = (FileSelectorUI.j)paramString.next();
        ((FileSelectorUI.j)localObject).Rwc = ((CharSequence)String.valueOf(((FileSelectorUI.j)localObject).Rwc));
        ((FileSelectorUI.j)localObject).aA((CharSequence)((FileSelectorUI.j)localObject).hnu().toString());
        localObject = ((FileSelectorUI.j)localObject).hnt();
        this.RvC.add(localObject);
      }
    }
    Iterator localIterator = this.RvB.iterator();
    FileSelectorUI.j localj;
    if (localIterator.hasNext())
    {
      localj = (FileSelectorUI.j)localIterator.next();
      localObject = localj.Rwc;
      if (localObject != null) {
        break label244;
      }
      localObject = (CharSequence)"";
    }
    label244:
    for (;;)
    {
      boolean bool1 = n.a(localj.hnu(), (CharSequence)paramString, true);
      boolean bool2 = n.a((CharSequence)localObject, (CharSequence)paramString, true);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if (bool1) {
        localj.aA(a(paramString, localj.hnu()));
      }
      if (bool2) {
        localj.Rwc = a(paramString, (CharSequence)localObject);
      }
      this.RvC.add(localj);
      break;
      return this.RvC;
    }
  }
  
  protected final int hno()
  {
    return this.RvA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.d
 * JD-Core Version:    0.7.0.1
 */