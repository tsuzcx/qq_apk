package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzu
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int Height;
  public SKBuiltinBuffer_t MZq;
  public String Md5;
  public int Width;
  public int oUq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125784);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      if (this.MZq != null)
      {
        paramVarArgs.ni(2, this.MZq.computeSize());
        this.MZq.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Width);
      paramVarArgs.aM(4, this.Height);
      paramVarArgs.aM(5, this.oUq);
      if (this.Desc != null) {
        paramVarArgs.e(6, this.Desc);
      }
      AppMethodBeat.o(125784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.f(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MZq != null) {
        i = paramInt + g.a.a.a.nh(2, this.MZq.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.Width) + g.a.a.b.b.a.bu(4, this.Height) + g.a.a.b.b.a.bu(5, this.oUq);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Desc);
      }
      AppMethodBeat.o(125784);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzu localdzu = (dzu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125784);
          return -1;
        case 1: 
          localdzu.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125784);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzu.MZq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125784);
          return 0;
        case 3: 
          localdzu.Width = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125784);
          return 0;
        case 4: 
          localdzu.Height = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125784);
          return 0;
        case 5: 
          localdzu.oUq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125784);
          return 0;
        }
        localdzu.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125784);
        return 0;
      }
      AppMethodBeat.o(125784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzu
 * JD-Core Version:    0.7.0.1
 */