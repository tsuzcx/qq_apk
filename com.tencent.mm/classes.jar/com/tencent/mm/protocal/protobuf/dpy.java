package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpy
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t Gub;
  public int HEc;
  public String HEd;
  public String HEe;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152715);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HEc);
      if (this.HEd != null) {
        paramVarArgs.d(2, this.HEd);
      }
      if (this.HEe != null) {
        paramVarArgs.d(3, this.HEe);
      }
      paramVarArgs.aS(4, this.Scene);
      if (this.Gub != null)
      {
        paramVarArgs.lC(5, this.Gub.computeSize());
        this.Gub.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HEc) + 0;
      paramInt = i;
      if (this.HEd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HEd);
      }
      i = paramInt;
      if (this.HEe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HEe);
      }
      i += f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.Gub != null) {
        paramInt = i + f.a.a.a.lB(5, this.Gub.computeSize());
      }
      AppMethodBeat.o(152715);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dpy localdpy = (dpy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152715);
        return -1;
      case 1: 
        localdpy.HEc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152715);
        return 0;
      case 2: 
        localdpy.HEd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 3: 
        localdpy.HEe = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 4: 
        localdpy.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152715);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdpy.Gub = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    AppMethodBeat.o(152715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpy
 * JD-Core Version:    0.7.0.1
 */