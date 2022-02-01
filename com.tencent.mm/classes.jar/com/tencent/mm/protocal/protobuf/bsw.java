package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsw
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public LinkedList<dbp> CRg;
  public dbp Cvo;
  public String DPX;
  
  public bsw()
  {
    AppMethodBeat.i(91553);
    this.CRg = new LinkedList();
    AppMethodBeat.o(91553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cvo != null)
      {
        paramVarArgs.kX(1, this.Cvo.computeSize());
        this.Cvo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.CRg);
      if (this.CDW != null) {
        paramVarArgs.d(3, this.CDW);
      }
      if (this.DPX != null) {
        paramVarArgs.d(4, this.DPX);
      }
      AppMethodBeat.o(91554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cvo == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.kW(1, this.Cvo.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.CRg);
      paramInt = i;
      if (this.CDW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CDW);
      }
      i = paramInt;
      if (this.DPX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DPX);
      }
      AppMethodBeat.o(91554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CRg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsw localbsw = (bsw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91554);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsw.Cvo = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbsw.CRg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 3: 
          localbsw.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91554);
          return 0;
        }
        localbsw.DPX = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91554);
        return 0;
      }
      AppMethodBeat.o(91554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsw
 * JD-Core Version:    0.7.0.1
 */