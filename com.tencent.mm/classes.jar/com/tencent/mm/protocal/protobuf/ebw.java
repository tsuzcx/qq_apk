package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ebw
  extends com.tencent.mm.bx.a
{
  public dya LAm;
  public int LqD;
  public long Lro;
  public long Lrp;
  public long Lrq;
  public int Lrr;
  public int Lrs;
  public float Lrt;
  public long bxw;
  public long gnO;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203594);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(203594);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      paramVarArgs.aR(2, this.type);
      paramVarArgs.aG(3, this.bxw);
      paramVarArgs.aG(4, this.gnO);
      paramVarArgs.aG(5, this.Lro);
      paramVarArgs.aG(6, this.Lrp);
      paramVarArgs.aG(7, this.Lrq);
      paramVarArgs.aR(8, this.Lrr);
      paramVarArgs.aR(9, this.Lrs);
      paramVarArgs.x(10, this.Lrt);
      if (this.LAm != null)
      {
        paramVarArgs.kX(11, this.LAm.computeSize());
        this.LAm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.LqD);
      AppMethodBeat.o(203594);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label857;
      }
    }
    label857:
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.type) + f.a.a.b.b.a.q(3, this.bxw) + f.a.a.b.b.a.q(4, this.gnO) + f.a.a.b.b.a.q(5, this.Lro) + f.a.a.b.b.a.q(6, this.Lrp) + f.a.a.b.b.a.q(7, this.Lrq) + f.a.a.b.b.a.bA(8, this.Lrr) + f.a.a.b.b.a.bA(9, this.Lrs) + (f.a.a.b.b.a.fY(10) + 4);
      paramInt = i;
      if (this.LAm != null) {
        paramInt = i + f.a.a.a.kW(11, this.LAm.computeSize());
      }
      i = f.a.a.b.b.a.bA(12, this.LqD);
      AppMethodBeat.o(203594);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(203594);
          throw paramVarArgs;
        }
        AppMethodBeat.o(203594);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebw localebw = (ebw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203594);
          return -1;
        case 1: 
          localebw.path = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203594);
          return 0;
        case 2: 
          localebw.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203594);
          return 0;
        case 3: 
          localebw.bxw = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203594);
          return 0;
        case 4: 
          localebw.gnO = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203594);
          return 0;
        case 5: 
          localebw.Lro = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203594);
          return 0;
        case 6: 
          localebw.Lrp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203594);
          return 0;
        case 7: 
          localebw.Lrq = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203594);
          return 0;
        case 8: 
          localebw.Lrr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203594);
          return 0;
        case 9: 
          localebw.Lrs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203594);
          return 0;
        case 10: 
          localebw.Lrt = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(203594);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dya();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dya)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebw.LAm = ((dya)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203594);
          return 0;
        }
        localebw.LqD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(203594);
        return 0;
      }
      AppMethodBeat.o(203594);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebw
 * JD-Core Version:    0.7.0.1
 */