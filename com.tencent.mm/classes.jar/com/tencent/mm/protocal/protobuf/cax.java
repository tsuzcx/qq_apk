package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cax
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public SKBuiltinBuffer_t KMS;
  public long Mgq;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32320);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32320);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Mgq);
      paramVarArgs.aM(2, this.CreateTime);
      if (this.KMS != null)
      {
        paramVarArgs.ni(3, this.KMS.computeSize());
        this.KMS.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.oUv);
      AppMethodBeat.o(32320);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Mgq) + 0 + g.a.a.b.b.a.bu(2, this.CreateTime);
      paramInt = i;
      if (this.KMS != null) {
        paramInt = i + g.a.a.a.nh(3, this.KMS.computeSize());
      }
      i = g.a.a.b.b.a.bu(4, this.oUv);
      AppMethodBeat.o(32320);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KMS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32320);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32320);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cax localcax = (cax)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32320);
        return -1;
      case 1: 
        localcax.Mgq = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(32320);
        return 0;
      case 2: 
        localcax.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32320);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcax.KMS = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32320);
        return 0;
      }
      localcax.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(32320);
      return 0;
    }
    AppMethodBeat.o(32320);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cax
 * JD-Core Version:    0.7.0.1
 */