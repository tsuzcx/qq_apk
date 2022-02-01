package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uh
  extends cvw
{
  public String GlY;
  public String nickname;
  public String oIy;
  public int vxx;
  public String yoB;
  public String yoC;
  public String yoT;
  public String yoW;
  public String yoq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91400);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.vxx);
      if (this.oIy != null) {
        paramVarArgs.d(3, this.oIy);
      }
      if (this.yoT != null) {
        paramVarArgs.d(4, this.yoT);
      }
      if (this.GlY != null) {
        paramVarArgs.d(5, this.GlY);
      }
      if (this.yoB != null) {
        paramVarArgs.d(6, this.yoB);
      }
      if (this.yoC != null) {
        paramVarArgs.d(7, this.yoC);
      }
      if (this.yoW != null) {
        paramVarArgs.d(8, this.yoW);
      }
      if (this.nickname != null) {
        paramVarArgs.d(9, this.nickname);
      }
      if (this.yoq != null) {
        paramVarArgs.d(10, this.yoq);
      }
      AppMethodBeat.o(91400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.vxx);
      paramInt = i;
      if (this.oIy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oIy);
      }
      i = paramInt;
      if (this.yoT != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.yoT);
      }
      paramInt = i;
      if (this.GlY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GlY);
      }
      i = paramInt;
      if (this.yoB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.yoB);
      }
      paramInt = i;
      if (this.yoC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.yoC);
      }
      i = paramInt;
      if (this.yoW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.yoW);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nickname);
      }
      i = paramInt;
      if (this.yoq != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.yoq);
      }
      AppMethodBeat.o(91400);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uh localuh = (uh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91400);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91400);
          return 0;
        case 2: 
          localuh.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91400);
          return 0;
        case 3: 
          localuh.oIy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 4: 
          localuh.yoT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 5: 
          localuh.GlY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 6: 
          localuh.yoB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 7: 
          localuh.yoC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 8: 
          localuh.yoW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 9: 
          localuh.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91400);
          return 0;
        }
        localuh.yoq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91400);
        return 0;
      }
      AppMethodBeat.o(91400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uh
 * JD-Core Version:    0.7.0.1
 */