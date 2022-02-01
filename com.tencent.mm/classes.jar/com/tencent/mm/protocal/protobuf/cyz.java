package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyz
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t GQI;
  public String GQJ;
  public long GQL;
  public int ReqType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GQJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ReqType);
      if (this.GQJ != null) {
        paramVarArgs.d(2, this.GQJ);
      }
      if (this.GQI != null)
      {
        paramVarArgs.lJ(3, this.GQI.computeSize());
        this.GQI.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(4, this.GQL);
      AppMethodBeat.o(104834);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ReqType) + 0;
      paramInt = i;
      if (this.GQJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GQJ);
      }
      i = paramInt;
      if (this.GQI != null) {
        i = paramInt + f.a.a.a.lI(3, this.GQI.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(4, this.GQL);
      AppMethodBeat.o(104834);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GQJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104834);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cyz localcyz = (cyz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104834);
        return -1;
      case 1: 
        localcyz.ReqType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104834);
        return 0;
      case 2: 
        localcyz.GQJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(104834);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyz.GQI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104834);
        return 0;
      }
      localcyz.GQL = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(104834);
      return 0;
    }
    AppMethodBeat.o(104834);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyz
 * JD-Core Version:    0.7.0.1
 */