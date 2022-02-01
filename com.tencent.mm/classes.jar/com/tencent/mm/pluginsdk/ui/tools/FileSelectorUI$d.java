package com.tencent.mm.pluginsdk.ui.tools;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "DEFAULT_PAGESIZE", "", "getDEFAULT_PAGESIZE", "()I", "setDEFAULT_PAGESIZE", "(I)V", "getAdapter", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "fileList", "", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "getFileList", "()Ljava/util/List;", "setFileList", "(Ljava/util/List;)V", "hasInit", "", "getHasInit", "()Z", "setHasInit", "(Z)V", "searchList", "startIndex", "getStartIndex", "setStartIndex", "talker", "", "getTalker", "()Ljava/lang/String;", "setTalker", "(Ljava/lang/String;)V", "getData", "getDisplayName", "fromUser", "getHighLightContent", "", "key", "content", "initASync", "", "loadMoreAsync", "search", "app_release"})
public abstract class FileSelectorUI$d
{
  final FileSelectorUI.e Kuf;
  int Kut;
  List<FileSelectorUI.i> Kuu;
  private List<FileSelectorUI.i> Kuv;
  boolean hasInit;
  int startIndex;
  String talker;
  
  public FileSelectorUI$d(FileSelectorUI.e parame)
  {
    this.Kuf = localObject;
    this.Kut = 100;
    parame = Collections.synchronizedList((List)new ArrayList());
    p.g(parame, "Collections.synchronized…rrayList<ListFileItem>())");
    this.Kuu = parame;
    parame = Collections.synchronizedList((List)new ArrayList());
    p.g(parame, "Collections.synchronized…rrayList<ListFileItem>())");
    this.Kuv = parame;
    parame = z.aTY();
    p.g(parame, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.talker = parame;
  }
  
  private static CharSequence a(String paramString, CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    int i = n.a(paramCharSequence, paramString, 0, true);
    localSpannableString.setSpan(new ForegroundColorSpan(b.b.wZQ), i, paramString.length() + i, 33);
    localSpannableStringBuilder.append((CharSequence)localSpannableString);
    return (CharSequence)localSpannableStringBuilder;
  }
  
  public final List<FileSelectorUI.i> bfx(String paramString)
  {
    this.Kuv.clear();
    Object localObject1;
    Object localObject3;
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.Kuu.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (FileSelectorUI.i)paramString.next();
        ((FileSelectorUI.i)localObject1).KuS = ((CharSequence)String.valueOf(((FileSelectorUI.i)localObject1).KuS));
        ((FileSelectorUI.i)localObject1).am((CharSequence)((FileSelectorUI.i)localObject1).gsq().toString());
        localObject2 = new FileSelectorUI.i(((FileSelectorUI.i)localObject1).Kup);
        ((FileSelectorUI.i)localObject2).a(((FileSelectorUI.k)localObject1).KuY);
        ((FileSelectorUI.k)localObject2).title = ((FileSelectorUI.k)localObject1).title;
        ((FileSelectorUI.i)localObject2).d(((FileSelectorUI.i)localObject1).gsr());
        ((FileSelectorUI.i)localObject2).msgId = ((FileSelectorUI.i)localObject1).msgId;
        ((FileSelectorUI.i)localObject2).createTime = ((FileSelectorUI.i)localObject1).createTime;
        ((FileSelectorUI.i)localObject2).KuS = ((FileSelectorUI.i)localObject1).KuS;
        localObject3 = ((FileSelectorUI.i)localObject1).KuT;
        if (localObject3 == null) {
          p.btv("fileName");
        }
        ((FileSelectorUI.i)localObject2).KuT = ((CharSequence)localObject3);
        ((FileSelectorUI.i)localObject2).filePath = ((FileSelectorUI.i)localObject1).filePath;
        ((FileSelectorUI.i)localObject2).zGp = ((FileSelectorUI.i)localObject1).zGp;
        ((FileSelectorUI.i)localObject2).KuU = ((FileSelectorUI.i)localObject1).KuU;
        ((FileSelectorUI.i)localObject2).KuV = ((FileSelectorUI.i)localObject1).KuV;
        this.Kuv.add(localObject2);
      }
    }
    Object localObject2 = this.Kuu.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FileSelectorUI.i)((Iterator)localObject2).next();
      localObject1 = ((FileSelectorUI.i)localObject3).KuS;
      if (localObject1 != null) {
        break label381;
      }
      localObject1 = (CharSequence)"";
    }
    label381:
    for (;;)
    {
      CharSequence localCharSequence = ((FileSelectorUI.i)localObject3).gsq();
      if (paramString == null) {
        p.hyc();
      }
      boolean bool1 = n.a(localCharSequence, (CharSequence)paramString, true);
      boolean bool2 = n.a((CharSequence)localObject1, (CharSequence)paramString, true);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if (bool1) {
        ((FileSelectorUI.i)localObject3).am(a(paramString, ((FileSelectorUI.i)localObject3).gsq()));
      }
      if (bool2) {
        ((FileSelectorUI.i)localObject3).KuS = a(paramString, (CharSequence)localObject1);
      }
      this.Kuv.add(localObject3);
      break;
      return this.Kuv;
    }
  }
  
  protected final String getDisplayName(String paramString)
  {
    String str = z.aTY();
    if ((Util.isNullOrNil(paramString)) || (p.j(paramString, str))) {}
    for (paramString = this.Kup.getString(2131763426);; paramString = aa.getDisplayName(paramString))
    {
      paramString = this.Kup.getString(2131757531, new Object[] { paramString });
      p.g(paramString, "getString(R.string.chatt…ce_from, displayFromUser)");
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.d
 * JD-Core Version:    0.7.0.1
 */