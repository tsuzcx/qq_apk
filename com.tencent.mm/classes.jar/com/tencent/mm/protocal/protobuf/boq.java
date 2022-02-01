package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class boq
  extends com.tencent.mm.bx.a
{
  public acp CCa;
  public SKBuiltinBuffer_t CFU;
  public String CGf;
  public String CGs;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CFU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.CCa == null)
      {
        paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
        AppMethodBeat.o(133178);
        throw paramVarArgs;
      }
      if (this.CFU != null)
      {
        paramVarArgs.kX(1, this.CFU.computeSize());
        this.CFU.writeFields(paramVarArgs);
      }
      if (this.CCa != null)
      {
        paramVarArgs.kX(2, this.CCa.computeSize());
        this.CCa.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      if (this.CGf != null) {
        paramVarArgs.d(4, this.CGf);
      }
      if (this.CGs != null) {
        paramVarArgs.d(5, this.CGs);
      }
      AppMethodBeat.o(133178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CFU == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.a.kW(1, this.CFU.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CCa != null) {
        paramInt = i + f.a.a.a.kW(2, this.CCa.computeSize());
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mAQ);
      }
      paramInt = i;
      if (this.CGf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CGf);
      }
      i = paramInt;
      if (this.CGs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CGs);
      }
      AppMethodBeat.o(133178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CFU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        if (this.CCa == null)
        {
          paramVarArgs = new b("Not all required fields were included: CliPubECDHKey");
          AppMethodBeat.o(133178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        boq localboq = (boq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133178);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboq.CFU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboq.CCa = ((acp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133178);
          return 0;
        case 3: 
          localboq.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133178);
          return 0;
        case 4: 
          localboq.CGf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133178);
          return 0;
        }
        localboq.CGs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133178);
        return 0;
      }
      AppMethodBeat.o(133178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boq
 * JD-Core Version:    0.7.0.1
 */