package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class exh
  extends dyy
{
  public int CreateTime;
  public int HmZ;
  public int Hna;
  public int Hnb;
  public String UserName;
  public String UxD;
  public String lVG;
  public String lVJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.lVJ != null) {
        paramVarArgs.f(3, this.lVJ);
      }
      if (this.UxD != null) {
        paramVarArgs.f(4, this.UxD);
      }
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      paramVarArgs.aY(6, this.HmZ);
      paramVarArgs.aY(7, this.Hna);
      paramVarArgs.aY(8, this.Hnb);
      paramVarArgs.aY(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label783;
      }
    }
    label783:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.lVJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lVJ);
      }
      paramInt = i;
      if (this.UxD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UxD);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UserName);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.HmZ);
      int j = g.a.a.b.b.a.bM(7, this.Hna);
      int k = g.a.a.b.b.a.bM(8, this.Hnb);
      int m = g.a.a.b.b.a.bM(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        exh localexh = (exh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32485);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localexh.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(32485);
          return 0;
        case 2: 
          localexh.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 3: 
          localexh.lVJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 4: 
          localexh.UxD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 5: 
          localexh.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 6: 
          localexh.HmZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32485);
          return 0;
        case 7: 
          localexh.Hna = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32485);
          return 0;
        case 8: 
          localexh.Hnb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32485);
          return 0;
        }
        localexh.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32485);
        return 0;
      }
      AppMethodBeat.o(32485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exh
 * JD-Core Version:    0.7.0.1
 */