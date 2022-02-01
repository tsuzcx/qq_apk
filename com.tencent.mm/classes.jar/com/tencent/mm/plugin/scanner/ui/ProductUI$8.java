package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.scanner.model.a;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class ProductUI$8
  implements cl.a
{
  ProductUI$8(ProductUI paramProductUI) {}
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(51861);
    Object localObject1 = w.a(parama.mpN.YFG);
    Log.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
    parama = ProductUI.a(this.OZW);
    Object localObject2;
    if ((parama != null) && (!Util.isNullOrNil((String)localObject1)))
    {
      localObject1 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
      localObject2 = (String)((Map)localObject1).get(".sysmsg.scanproductinfo.product.id");
      if ((!Util.isNullOrNil(parama.field_productid)) && (parama.field_productid.equals(localObject2))) {
        break label144;
      }
      Log.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + Util.nullAsNil((String)localObject2) + ", target=" + parama.field_productid);
    }
    for (;;)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51860);
          ProductUI.a(ProductUI.8.this.OZW, ProductUI.a(ProductUI.8.this.OZW));
          AppMethodBeat.o(51860);
        }
      });
      AppMethodBeat.o(51861);
      return;
      label144:
      localObject1 = a.q((Map)localObject1, ".sysmsg.scanproductinfo.product");
      localObject2 = new HashMap();
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        LinkedList localLinkedList = ((a)((List)localObject1).get(i)).sXD;
        if (localLinkedList != null)
        {
          int j = 0;
          while (j < localLinkedList.size())
          {
            a.a locala = (a.a)localLinkedList.get(j);
            if (locala != null) {
              ((Map)localObject2).put(locala.key, locala);
            }
            j += 1;
          }
        }
        i += 1;
      }
      Log.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + ((Map)localObject2).size());
      y.c(parama.PjJ, (Map)localObject2);
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.8
 * JD-Core Version:    0.7.0.1
 */