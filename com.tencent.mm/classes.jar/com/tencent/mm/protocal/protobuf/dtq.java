package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtq
  extends com.tencent.mm.bx.a
{
  public int GVe;
  public LinkedList<dtr> HGt;
  public String HGu;
  public int HGv;
  public int apptype;
  public String duW;
  public String hBg;
  public String oBP;
  
  public dtq()
  {
    AppMethodBeat.i(74672);
    this.HGt = new LinkedList();
    AppMethodBeat.o(74672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74673);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.hBg != null) {
        paramVarArgs.d(2, this.hBg);
      }
      paramVarArgs.aS(3, this.apptype);
      paramVarArgs.e(4, 8, this.HGt);
      paramVarArgs.aS(5, this.GVe);
      if (this.HGu != null) {
        paramVarArgs.d(6, this.HGu);
      }
      if (this.oBP != null) {
        paramVarArgs.d(7, this.oBP);
      }
      paramVarArgs.aS(8, this.HGv);
      AppMethodBeat.o(74673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.duW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hBg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hBg);
      }
      i = i + f.a.a.b.b.a.bz(3, this.apptype) + f.a.a.a.c(4, 8, this.HGt) + f.a.a.b.b.a.bz(5, this.GVe);
      paramInt = i;
      if (this.HGu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HGu);
      }
      i = paramInt;
      if (this.oBP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.oBP);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.HGv);
      AppMethodBeat.o(74673);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HGt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(74673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtq localdtq = (dtq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74673);
          return -1;
        case 1: 
          localdtq.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 2: 
          localdtq.hBg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 3: 
          localdtq.apptype = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(74673);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dtr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtq.HGt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74673);
          return 0;
        case 5: 
          localdtq.GVe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(74673);
          return 0;
        case 6: 
          localdtq.HGu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 7: 
          localdtq.oBP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(74673);
          return 0;
        }
        localdtq.HGv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(74673);
        return 0;
      }
      AppMethodBeat.o(74673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtq
 * JD-Core Version:    0.7.0.1
 */