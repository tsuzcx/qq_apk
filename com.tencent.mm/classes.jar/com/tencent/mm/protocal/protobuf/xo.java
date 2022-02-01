package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xo
  extends com.tencent.mm.bx.a
{
  public String CRq;
  public String CRr;
  public long CSH;
  public String CSI;
  public String CSJ;
  public beh CZh;
  public String nrs;
  public String nrt;
  public String odo;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.nrs != null) {
        paramVarArgs.d(2, this.nrs);
      }
      if (this.nrt != null) {
        paramVarArgs.d(3, this.nrt);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.aG(5, this.CSH);
      if (this.CSI != null) {
        paramVarArgs.d(6, this.CSI);
      }
      if (this.CSJ != null) {
        paramVarArgs.d(7, this.CSJ);
      }
      if (this.odo != null) {
        paramVarArgs.d(8, this.odo);
      }
      if (this.CZh != null)
      {
        paramVarArgs.kX(9, this.CZh.computeSize());
        this.CZh.writeFields(paramVarArgs);
      }
      if (this.CRq != null) {
        paramVarArgs.d(10, this.CRq);
      }
      if (this.CRr != null) {
        paramVarArgs.d(11, this.CRr);
      }
      AppMethodBeat.o(113985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nrs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nrs);
      }
      i = paramInt;
      if (this.nrt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nrt);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.CSH);
      paramInt = i;
      if (this.CSI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CSI);
      }
      i = paramInt;
      if (this.CSJ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CSJ);
      }
      paramInt = i;
      if (this.odo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.odo);
      }
      i = paramInt;
      if (this.CZh != null) {
        i = paramInt + f.a.a.a.kW(9, this.CZh.computeSize());
      }
      paramInt = i;
      if (this.CRq != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CRq);
      }
      i = paramInt;
      if (this.CRr != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CRr);
      }
      AppMethodBeat.o(113985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xo localxo = (xo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113985);
          return -1;
        case 1: 
          localxo.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 2: 
          localxo.nrs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 3: 
          localxo.nrt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 4: 
          localxo.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 5: 
          localxo.CSH = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(113985);
          return 0;
        case 6: 
          localxo.CSI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 7: 
          localxo.CSJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 8: 
          localxo.odo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new beh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((beh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxo.CZh = ((beh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113985);
          return 0;
        case 10: 
          localxo.CRq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113985);
          return 0;
        }
        localxo.CRr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113985);
        return 0;
      }
      AppMethodBeat.o(113985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xo
 * JD-Core Version:    0.7.0.1
 */