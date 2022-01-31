package com.tencent.view;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterWraper;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.a.by;
import com.tencent.filter.a.cj;
import com.tencent.filter.art.DofCpuFilter;
import com.tencent.filter.art.OilPaintFilter;
import com.tencent.filter.g;
import com.tencent.filter.i;
import com.tencent.filter.j;
import com.tencent.filter.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  public static BaseFilter createFilter(int paramInt)
  {
    AppMethodBeat.i(86636);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = cj.creatFilterById(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(86636);
      return localObject;
      localObject = new BaseFilter(GLSLRender.btg);
      continue;
      localObject = new com.tencent.filter.f();
      continue;
      localObject = new com.tencent.filter.a(GLSLRender.btj);
      continue;
      localObject = new com.tencent.filter.a(GLSLRender.btk);
      continue;
      localObject = new com.tencent.filter.b(GLSLRender.btg, 1);
      continue;
      localObject = new com.tencent.filter.e("rise.png");
      continue;
      localObject = new com.tencent.filter.b(GLSLRender.btg, 0);
      continue;
      localObject = new by();
      continue;
      localObject = new com.tencent.filter.e("hudson.png");
      continue;
      localObject = new com.tencent.filter.art.a(GLSLRender.btg);
      continue;
      localObject = new g();
      continue;
      localObject = new com.tencent.filter.e("xpro2.png");
      continue;
      localObject = new j();
      continue;
      localObject = new com.tencent.filter.art.e();
      continue;
      localObject = new com.tencent.filter.e("qiurisiyu.png");
      continue;
      localObject = new com.tencent.filter.e("jingdianheibai.png");
      ((com.tencent.filter.e)localObject).setMatrix(new float[] { 0.299F, 0.299F, 0.299F, 0.0F, 0.587F, 0.587F, 0.587F, 0.0F, 0.114F, 0.114F, 0.114F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      continue;
      localObject = new com.tencent.filter.e("danya.png");
      ((com.tencent.filter.e)localObject).setMatrix(new float[] { 0.825F, 0.075F, 0.075F, 0.0F, 0.147F, 0.897F, 0.147F, 0.0F, 0.029F, 0.029F, 0.779F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      continue;
      localObject = new BaseFilter(GLSLRender.btq, "colorPencil.png");
      continue;
      localObject = new BaseFilter(GLSLRender.buw, "sketch.png");
      continue;
      localObject = new BaseFilter(GLSLRender.buv);
      continue;
      localObject = new com.tencent.filter.art.b(0);
      continue;
      localObject = new com.tencent.filter.art.b(1);
      continue;
      localObject = new com.tencent.filter.art.b(2);
      continue;
      localObject = new OilPaintFilter(0);
      continue;
      localObject = new OilPaintFilter(1);
      continue;
      localObject = new DofCpuFilter(0);
      continue;
      localObject = new DofCpuFilter(1);
      continue;
      localObject = new com.tencent.filter.art.f();
      continue;
      localObject = new com.tencent.filter.art.d();
      continue;
      localObject = new i();
      continue;
      localObject = new com.tencent.filter.d();
      continue;
      localObject = new n();
      continue;
      localObject = new FilterWraper("Curve2D/amaro");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.view.e
 * JD-Core Version:    0.7.0.1
 */