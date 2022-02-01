package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccu
  extends com.tencent.mm.bw.a
{
  public String DMR;
  public String Frl;
  public String Frm;
  public String Frn;
  public int Fro;
  public LinkedList<qz> Frp;
  public String Frq;
  public String Frr;
  
  public ccu()
  {
    AppMethodBeat.i(114047);
    this.Frp = new LinkedList();
    AppMethodBeat.o(114047);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DMR != null) {
        paramVarArgs.d(1, this.DMR);
      }
      if (this.Frl != null) {
        paramVarArgs.d(2, this.Frl);
      }
      if (this.Frm != null) {
        paramVarArgs.d(3, this.Frm);
      }
      if (this.Frn != null) {
        paramVarArgs.d(4, this.Frn);
      }
      paramVarArgs.aR(5, this.Fro);
      paramVarArgs.e(6, 8, this.Frp);
      if (this.Frq != null) {
        paramVarArgs.d(7, this.Frq);
      }
      if (this.Frr != null) {
        paramVarArgs.d(8, this.Frr);
      }
      AppMethodBeat.o(114048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DMR == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.DMR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Frl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Frl);
      }
      i = paramInt;
      if (this.Frm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Frm);
      }
      paramInt = i;
      if (this.Frn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Frn);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Fro) + f.a.a.a.c(6, 8, this.Frp);
      paramInt = i;
      if (this.Frq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Frq);
      }
      i = paramInt;
      if (this.Frr != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Frr);
      }
      AppMethodBeat.o(114048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Frp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccu localccu = (ccu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114048);
          return -1;
        case 1: 
          localccu.DMR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 2: 
          localccu.Frl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 3: 
          localccu.Frm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 4: 
          localccu.Frn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 5: 
          localccu.Fro = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114048);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((qz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccu.Frp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114048);
          return 0;
        case 7: 
          localccu.Frq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114048);
          return 0;
        }
        localccu.Frr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114048);
        return 0;
      }
      AppMethodBeat.o(114048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccu
 * JD-Core Version:    0.7.0.1
 */