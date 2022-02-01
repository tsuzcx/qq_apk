package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class edg
  extends dyl
{
  public String Md5;
  public int RLs;
  public int ScX;
  public int ScY;
  public String ScZ;
  public int Sue;
  public fa UhI;
  public String UhJ;
  public String UhK;
  public int UhL;
  public int UhM;
  public String mVB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UhI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Msg");
        AppMethodBeat.o(32426);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UhI != null)
      {
        paramVarArgs.oE(2, this.UhI.computeSize());
        this.UhI.writeFields(paramVarArgs);
      }
      if (this.UhJ != null) {
        paramVarArgs.f(3, this.UhJ);
      }
      paramVarArgs.aY(4, this.Sue);
      if (this.Md5 != null) {
        paramVarArgs.f(5, this.Md5);
      }
      paramVarArgs.aY(6, this.RLs);
      if (this.mVB != null) {
        paramVarArgs.f(7, this.mVB);
      }
      if (this.UhK != null) {
        paramVarArgs.f(8, this.UhK);
      }
      paramVarArgs.aY(9, this.UhL);
      paramVarArgs.aY(10, this.ScX);
      paramVarArgs.aY(11, this.ScY);
      paramVarArgs.aY(12, this.UhM);
      if (this.ScZ != null) {
        paramVarArgs.f(13, this.ScZ);
      }
      AppMethodBeat.o(32426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1065;
      }
    }
    label1065:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UhI != null) {
        paramInt = i + g.a.a.a.oD(2, this.UhI.computeSize());
      }
      i = paramInt;
      if (this.UhJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UhJ);
      }
      i += g.a.a.b.b.a.bM(4, this.Sue);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Md5);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.RLs);
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.mVB);
      }
      i = paramInt;
      if (this.UhK != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.UhK);
      }
      i = i + g.a.a.b.b.a.bM(9, this.UhL) + g.a.a.b.b.a.bM(10, this.ScX) + g.a.a.b.b.a.bM(11, this.ScY) + g.a.a.b.b.a.bM(12, this.UhM);
      paramInt = i;
      if (this.ScZ != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.ScZ);
      }
      AppMethodBeat.o(32426);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UhI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Msg");
          AppMethodBeat.o(32426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        edg localedg = (edg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32426);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localedg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fa)localObject2).parseFrom((byte[])localObject1);
            }
            localedg.UhI = ((fa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 3: 
          localedg.UhJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 4: 
          localedg.Sue = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32426);
          return 0;
        case 5: 
          localedg.Md5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 6: 
          localedg.RLs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32426);
          return 0;
        case 7: 
          localedg.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 8: 
          localedg.UhK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 9: 
          localedg.UhL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32426);
          return 0;
        case 10: 
          localedg.ScX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32426);
          return 0;
        case 11: 
          localedg.ScY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32426);
          return 0;
        case 12: 
          localedg.UhM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32426);
          return 0;
        }
        localedg.ScZ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32426);
        return 0;
      }
      AppMethodBeat.o(32426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edg
 * JD-Core Version:    0.7.0.1
 */