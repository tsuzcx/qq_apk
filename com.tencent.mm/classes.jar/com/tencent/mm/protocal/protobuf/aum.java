package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aum
  extends com.tencent.mm.bw.a
{
  public ecu GLn;
  public ecr GLo;
  public ect GLp;
  public boolean GLq;
  public boolean GLr;
  public String GLs;
  public String GLt;
  public int GLu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197189);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GLn != null)
      {
        paramVarArgs.lJ(1, this.GLn.computeSize());
        this.GLn.writeFields(paramVarArgs);
      }
      if (this.GLo != null)
      {
        paramVarArgs.lJ(2, this.GLo.computeSize());
        this.GLo.writeFields(paramVarArgs);
      }
      if (this.GLp != null)
      {
        paramVarArgs.lJ(3, this.GLp.computeSize());
        this.GLp.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(4, this.GLq);
      paramVarArgs.bC(5, this.GLr);
      if (this.GLs != null) {
        paramVarArgs.d(6, this.GLs);
      }
      if (this.GLt != null) {
        paramVarArgs.d(7, this.GLt);
      }
      paramVarArgs.aS(99, this.GLu);
      AppMethodBeat.o(197189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GLn == null) {
        break label894;
      }
    }
    label894:
    for (int i = f.a.a.a.lI(1, this.GLn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GLo != null) {
        paramInt = i + f.a.a.a.lI(2, this.GLo.computeSize());
      }
      i = paramInt;
      if (this.GLp != null) {
        i = paramInt + f.a.a.a.lI(3, this.GLp.computeSize());
      }
      i = i + f.a.a.b.b.a.amF(4) + f.a.a.b.b.a.amF(5);
      paramInt = i;
      if (this.GLs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GLs);
      }
      i = paramInt;
      if (this.GLt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GLt);
      }
      paramInt = f.a.a.b.b.a.bz(99, this.GLu);
      AppMethodBeat.o(197189);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197189);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aum localaum = (aum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197189);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaum.GLn = ((ecu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197189);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaum.GLo = ((ecr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197189);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ect();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ect)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaum.GLp = ((ect)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197189);
          return 0;
        case 4: 
          localaum.GLq = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(197189);
          return 0;
        case 5: 
          localaum.GLr = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(197189);
          return 0;
        case 6: 
          localaum.GLs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197189);
          return 0;
        case 7: 
          localaum.GLt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197189);
          return 0;
        }
        localaum.GLu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(197189);
        return 0;
      }
      AppMethodBeat.o(197189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aum
 * JD-Core Version:    0.7.0.1
 */