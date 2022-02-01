package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exa
  extends dyl
{
  public int RYL;
  public int SLl;
  public int UxA;
  public int UxB;
  public int bnA;
  public int scene;
  public String session_id;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123664);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.scene);
      paramVarArgs.aY(3, this.UxA);
      paramVarArgs.aY(4, this.RYL);
      paramVarArgs.aY(5, this.UxB);
      paramVarArgs.aY(6, this.SLl);
      if (this.username != null) {
        paramVarArgs.f(7, this.username);
      }
      paramVarArgs.aY(8, this.bnA);
      if (this.session_id != null) {
        paramVarArgs.f(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label672;
      }
    }
    label672:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.scene) + g.a.a.b.b.a.bM(3, this.UxA) + g.a.a.b.b.a.bM(4, this.RYL) + g.a.a.b.b.a.bM(5, this.UxB) + g.a.a.b.b.a.bM(6, this.SLl);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.username);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.bnA);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        exa localexa = (exa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123664);
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
            localexa.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(123664);
          return 0;
        case 2: 
          localexa.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123664);
          return 0;
        case 3: 
          localexa.UxA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123664);
          return 0;
        case 4: 
          localexa.RYL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123664);
          return 0;
        case 5: 
          localexa.UxB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123664);
          return 0;
        case 6: 
          localexa.SLl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123664);
          return 0;
        case 7: 
          localexa.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123664);
          return 0;
        case 8: 
          localexa.bnA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123664);
          return 0;
        }
        localexa.session_id = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123664);
        return 0;
      }
      AppMethodBeat.o(123664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exa
 * JD-Core Version:    0.7.0.1
 */