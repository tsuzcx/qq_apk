package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class c$a
  implements Runnable
{
  long createTime;
  HashSet<b> teN;
  ckw teO;
  
  private c$a(c paramc)
  {
    AppMethodBeat.i(65494);
    this.teN = new HashSet();
    AppMethodBeat.o(65494);
  }
  
  private static String a(List<b> paramList, ckw paramckw)
  {
    AppMethodBeat.i(65496);
    StringBuilder localStringBuilder1;
    try
    {
      int i = paramList.size();
      if (i == 0)
      {
        AppMethodBeat.o(65496);
        return null;
      }
      localStringBuilder1 = new StringBuilder("");
      localStringBuilder1.append("isexpose=1&content=");
      Object localObject1 = new StringBuilder("");
      Object localObject2 = paramList.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        ckx localckx = ((b)localObject3).tfm;
        ((StringBuilder)localObject1).append(localckx.cnw);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(localckx.uKI);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(((b)localObject3).nae);
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(localckx.xVd);
        ((StringBuilder)localObject1).append(";");
      }
      try
      {
        localStringBuilder1.append(q.encode(((StringBuilder)localObject1).toString(), "utf-8"));
        localStringBuilder1.append("&resulttype=");
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((b)((Iterator)localObject1).next()).tfm;
          localStringBuilder1.append(((ckx)localObject2).cnw);
          localStringBuilder1.append(":");
          localStringBuilder1.append(((ckx)localObject2).xVh);
          localStringBuilder1.append(";");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localException, "", new Object[0]);
        }
        localStringBuilder1.append("&expand=");
        localStringBuilder2 = new StringBuilder("");
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((b)((Iterator)localObject2).next()).tfm;
          localStringBuilder2.append(((ckx)localObject3).cnw);
          localStringBuilder2.append(":");
          localStringBuilder2.append(((ckx)localObject3).xVf);
          localStringBuilder2.append(";");
        }
        try
        {
          localStringBuilder1.append(q.encode(localStringBuilder2.toString(), "utf-8"));
          localStringBuilder1.append("&itemtype=");
          localStringBuilder2 = new StringBuilder("");
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localStringBuilder2.append(((b)paramList.next()).tfm.xVe);
            localStringBuilder2.append(";");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localUnsupportedEncodingException, "", new Object[0]);
          }
          localStringBuilder1.append(localUnsupportedEncodingException);
          if (paramckw == null) {
            break label636;
          }
        }
        localStringBuilder1.append("&");
        localStringBuilder1.append("searchid=");
        localStringBuilder1.append(paramckw.hng);
        localStringBuilder1.append("&");
        localStringBuilder1.append("query=");
      }
    }
    catch (Exception paramList)
    {
      ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "build14057VideoInfoExposeString error: %s", new Object[] { paramList.getMessage() });
      AppMethodBeat.o(65496);
      return null;
    }
    try
    {
      StringBuilder localStringBuilder2;
      localStringBuilder1.append(q.encode(paramckw.cnv, "utf-8"));
      localStringBuilder1.append("&");
      localStringBuilder1.append("ishomepage=0");
      localStringBuilder1.append("&");
      localStringBuilder1.append("sessionid=");
      localStringBuilder1.append(aa.IZ(paramckw.scene));
      localStringBuilder1.append("&");
      localStringBuilder1.append("scene=");
      localStringBuilder1.append(paramckw.scene);
      localStringBuilder1.append("&rec_category=");
      localStringBuilder1.append(paramckw.xUO);
      label636:
      paramList = localStringBuilder1.toString();
      AppMethodBeat.o(65496);
      return paramList;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "", new Object[0]);
      }
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(65495);
    ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
    this.teM.teL.remove(Long.valueOf(this.teO.xUO));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.teN);
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 20;
      if (j >= localArrayList.size()) {}
      for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
      {
        String str = a(localList, this.teO);
        if (!bo.isNullOrNil(str))
        {
          buo localbuo = new buo();
          localbuo.xHP = str;
          ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localbuo.xHP });
          al.d(new c.a.1(this, localbuo));
        }
        if (j < localArrayList.size()) {
          break;
        }
        AppMethodBeat.o(65495);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c.a
 * JD-Core Version:    0.7.0.1
 */