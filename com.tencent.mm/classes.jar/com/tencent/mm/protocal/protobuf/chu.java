package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chu
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FOS;
  public SKBuiltinBuffer_t Huc;
  public String Md5;
  public String Name;
  public String PackName;
  public int Version;
  public int nJv;
  public int uvE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uvE);
      paramVarArgs.aS(2, this.Version);
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      paramVarArgs.aS(4, this.nJv);
      if (this.FOS != null)
      {
        paramVarArgs.lJ(5, this.FOS.computeSize());
        this.FOS.writeFields(paramVarArgs);
      }
      if (this.PackName != null) {
        paramVarArgs.d(6, this.PackName);
      }
      if (this.Huc != null)
      {
        paramVarArgs.lJ(7, this.Huc.computeSize());
        this.Huc.writeFields(paramVarArgs);
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
      i = f.a.a.b.b.a.bz(1, this.uvE) + 0 + f.a.a.b.b.a.bz(2, this.Version);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Name);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.nJv);
      paramInt = i;
      if (this.FOS != null) {
        paramInt = i + f.a.a.a.lI(5, this.FOS.computeSize());
      }
      i = paramInt;
      if (this.PackName != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.PackName);
      }
      paramInt = i;
      if (this.Huc != null) {
        paramInt = i + f.a.a.a.lI(7, this.Huc.computeSize());
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
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      chu localchu = (chu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152659);
        return -1;
      case 1: 
        localchu.uvE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152659);
        return 0;
      case 2: 
        localchu.Version = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152659);
        return 0;
      case 3: 
        localchu.Name = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 4: 
        localchu.nJv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152659);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchu.FOS = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      case 6: 
        localchu.PackName = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchu.Huc = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      }
      localchu.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(152659);
      return 0;
    }
    AppMethodBeat.o(152659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chu
 * JD-Core Version:    0.7.0.1
 */