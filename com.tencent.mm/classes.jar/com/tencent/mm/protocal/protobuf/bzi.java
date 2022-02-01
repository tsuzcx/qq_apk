package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzi
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b DWI;
  public int Fok;
  public String Fol;
  public SKBuiltinBuffer_t Fom;
  public int Fon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32359);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fom == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Fok);
      if (this.DWI != null) {
        paramVarArgs.c(2, this.DWI);
      }
      if (this.Fol != null) {
        paramVarArgs.d(3, this.Fol);
      }
      if (this.Fom != null)
      {
        paramVarArgs.ln(4, this.Fom.computeSize());
        this.Fom.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Fon);
      AppMethodBeat.o(32359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Fok) + 0;
      paramInt = i;
      if (this.DWI != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DWI);
      }
      i = paramInt;
      if (this.Fol != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fol);
      }
      paramInt = i;
      if (this.Fom != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fom.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.Fon);
      AppMethodBeat.o(32359);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Fom == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bzi localbzi = (bzi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32359);
        return -1;
      case 1: 
        localbzi.Fok = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32359);
        return 0;
      case 2: 
        localbzi.DWI = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(32359);
        return 0;
      case 3: 
        localbzi.Fol = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32359);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzi.Fom = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32359);
        return 0;
      }
      localbzi.Fon = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(32359);
      return 0;
    }
    AppMethodBeat.o(32359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzi
 * JD-Core Version:    0.7.0.1
 */