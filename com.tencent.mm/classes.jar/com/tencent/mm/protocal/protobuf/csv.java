package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csv
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t EOe;
  public String EOf;
  public long EOh;
  public int ReqType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(104834);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.ReqType);
      if (this.EOf != null) {
        paramVarArgs.d(2, this.EOf);
      }
      if (this.EOe != null)
      {
        paramVarArgs.ln(3, this.EOe.computeSize());
        this.EOe.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.EOh);
      AppMethodBeat.o(104834);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ReqType) + 0;
      paramInt = i;
      if (this.EOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EOf);
      }
      i = paramInt;
      if (this.EOe != null) {
        i = paramInt + f.a.a.a.lm(3, this.EOe.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(4, this.EOh);
      AppMethodBeat.o(104834);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.EOf == null)
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
      csv localcsv = (csv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104834);
        return -1;
      case 1: 
        localcsv.ReqType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104834);
        return 0;
      case 2: 
        localcsv.EOf = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(104834);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsv.EOe = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104834);
        return 0;
      }
      localcsv.EOh = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(104834);
      return 0;
    }
    AppMethodBeat.o(104834);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csv
 * JD-Core Version:    0.7.0.1
 */