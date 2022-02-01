package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccj
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DRc;
  public SKBuiltinBuffer_t FqS;
  public String Md5;
  public String Name;
  public String PackName;
  public int Version;
  public int ndD;
  public int tlI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.tlI);
      paramVarArgs.aR(2, this.Version);
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      paramVarArgs.aR(4, this.ndD);
      if (this.DRc != null)
      {
        paramVarArgs.ln(5, this.DRc.computeSize());
        this.DRc.writeFields(paramVarArgs);
      }
      if (this.PackName != null) {
        paramVarArgs.d(6, this.PackName);
      }
      if (this.FqS != null)
      {
        paramVarArgs.ln(7, this.FqS.computeSize());
        this.FqS.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(8, this.Md5);
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.tlI) + 0 + f.a.a.b.b.a.bx(2, this.Version);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Name);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.ndD);
      paramInt = i;
      if (this.DRc != null) {
        paramInt = i + f.a.a.a.lm(5, this.DRc.computeSize());
      }
      i = paramInt;
      if (this.PackName != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.PackName);
      }
      paramInt = i;
      if (this.FqS != null) {
        paramInt = i + f.a.a.a.lm(7, this.FqS.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Md5);
      }
      AppMethodBeat.o(152659);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ccj localccj = (ccj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152659);
        return -1;
      case 1: 
        localccj.tlI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152659);
        return 0;
      case 2: 
        localccj.Version = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152659);
        return 0;
      case 3: 
        localccj.Name = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 4: 
        localccj.ndD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152659);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccj.DRc = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      case 6: 
        localccj.PackName = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccj.FqS = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      }
      localccj.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(152659);
      return 0;
    }
    AppMethodBeat.o(152659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccj
 * JD-Core Version:    0.7.0.1
 */