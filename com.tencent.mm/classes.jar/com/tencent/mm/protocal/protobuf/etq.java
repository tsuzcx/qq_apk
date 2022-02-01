package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class etq
  extends dop
{
  public SKBuiltinBuffer_t KMS;
  public int LsZ;
  public long Lta;
  public int MKr;
  public int NqM;
  public int NqN;
  public int NqO;
  public int NqP;
  public int NqQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115876);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115876);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.MKr);
      paramVarArgs.aM(5, this.NqM);
      paramVarArgs.aM(6, this.NqN);
      paramVarArgs.aM(7, this.NqO);
      paramVarArgs.aM(8, this.NqP);
      paramVarArgs.aM(9, this.NqQ);
      if (this.KMS != null)
      {
        paramVarArgs.ni(10, this.KMS.computeSize());
        this.KMS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.MKr) + g.a.a.b.b.a.bu(5, this.NqM) + g.a.a.b.b.a.bu(6, this.NqN) + g.a.a.b.b.a.bu(7, this.NqO) + g.a.a.b.b.a.bu(8, this.NqP) + g.a.a.b.b.a.bu(9, this.NqQ);
      paramInt = i;
      if (this.KMS != null) {
        paramInt = i + g.a.a.a.nh(10, this.KMS.computeSize());
      }
      AppMethodBeat.o(115876);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KMS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(115876);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        etq localetq = (etq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115876);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localetq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115876);
          return 0;
        case 2: 
          localetq.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115876);
          return 0;
        case 3: 
          localetq.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115876);
          return 0;
        case 4: 
          localetq.MKr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115876);
          return 0;
        case 5: 
          localetq.NqM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115876);
          return 0;
        case 6: 
          localetq.NqN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115876);
          return 0;
        case 7: 
          localetq.NqO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115876);
          return 0;
        case 8: 
          localetq.NqP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115876);
          return 0;
        case 9: 
          localetq.NqQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115876);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localetq.KMS = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      AppMethodBeat.o(115876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etq
 * JD-Core Version:    0.7.0.1
 */