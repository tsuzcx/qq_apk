package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ady
  extends com.tencent.mm.bw.a
{
  public String DPY;
  public String EhE;
  public SKBuiltinBuffer_t EwI;
  public String EwJ;
  public String EwK;
  public String EwL;
  public int EwM;
  public String MD5;
  public int ndI;
  public String tlJ;
  public int vTH;
  public int vTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EwI == null)
      {
        paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(109446);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aR(2, this.vTI);
      paramVarArgs.aR(3, this.vTH);
      if (this.EwI != null)
      {
        paramVarArgs.ln(4, this.EwI.computeSize());
        this.EwI.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.ndI);
      if (this.tlJ != null) {
        paramVarArgs.d(6, this.tlJ);
      }
      if (this.EwJ != null) {
        paramVarArgs.d(7, this.EwJ);
      }
      if (this.EwK != null) {
        paramVarArgs.d(8, this.EwK);
      }
      if (this.EwL != null) {
        paramVarArgs.d(9, this.EwL);
      }
      if (this.DPY != null) {
        paramVarArgs.d(10, this.DPY);
      }
      paramVarArgs.aR(11, this.EwM);
      if (this.EhE != null) {
        paramVarArgs.d(12, this.EhE);
      }
      AppMethodBeat.o(109446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTI) + f.a.a.b.b.a.bx(3, this.vTH);
      paramInt = i;
      if (this.EwI != null) {
        paramInt = i + f.a.a.a.lm(4, this.EwI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.ndI);
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tlJ);
      }
      i = paramInt;
      if (this.EwJ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EwJ);
      }
      paramInt = i;
      if (this.EwK != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EwK);
      }
      i = paramInt;
      if (this.EwL != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EwL);
      }
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DPY);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.EwM);
      paramInt = i;
      if (this.EhE != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EhE);
      }
      AppMethodBeat.o(109446);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EwI == null)
        {
          paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(109446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(109446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ady localady = (ady)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(109446);
          return -1;
        case 1: 
          localady.MD5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 2: 
          localady.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(109446);
          return 0;
        case 3: 
          localady.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(109446);
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
            localady.EwI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(109446);
          return 0;
        case 5: 
          localady.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(109446);
          return 0;
        case 6: 
          localady.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 7: 
          localady.EwJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 8: 
          localady.EwK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 9: 
          localady.EwL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 10: 
          localady.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 11: 
          localady.EwM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(109446);
          return 0;
        }
        localady.EhE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(109446);
        return 0;
      }
      AppMethodBeat.o(109446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ady
 * JD-Core Version:    0.7.0.1
 */