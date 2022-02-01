package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvo
  extends dyl
{
  public int HmZ;
  public int Hna;
  public int Tfu;
  public int Tfv;
  public String Tfw;
  public int Tfx;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152570);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      paramVarArgs.aY(3, this.Tfu);
      paramVarArgs.aY(4, this.Tfv);
      if (this.Tfw != null) {
        paramVarArgs.f(5, this.Tfw);
      }
      paramVarArgs.aY(6, this.HmZ);
      paramVarArgs.aY(7, this.Hna);
      paramVarArgs.aY(8, this.Tfx);
      AppMethodBeat.o(152570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label636;
      }
    }
    label636:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Tfu) + g.a.a.b.b.a.bM(4, this.Tfv);
      paramInt = i;
      if (this.Tfw != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tfw);
      }
      i = g.a.a.b.b.a.bM(6, this.HmZ);
      int j = g.a.a.b.b.a.bM(7, this.Hna);
      int k = g.a.a.b.b.a.bM(8, this.Tfx);
      AppMethodBeat.o(152570);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bvo localbvo = (bvo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152570);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbvo.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(152570);
          return 0;
        case 2: 
          localbvo.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 3: 
          localbvo.Tfu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152570);
          return 0;
        case 4: 
          localbvo.Tfv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152570);
          return 0;
        case 5: 
          localbvo.Tfw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 6: 
          localbvo.HmZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152570);
          return 0;
        case 7: 
          localbvo.Hna = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152570);
          return 0;
        }
        localbvo.Tfx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152570);
        return 0;
      }
      AppMethodBeat.o(152570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvo
 * JD-Core Version:    0.7.0.1
 */