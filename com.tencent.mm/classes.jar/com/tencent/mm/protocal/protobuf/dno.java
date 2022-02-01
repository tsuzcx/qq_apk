package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dno
  extends dyl
{
  public boolean TUO;
  public int TdQ;
  public int TnH;
  public String appid;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      paramVarArgs.aY(4, this.TnH);
      if (this.path != null) {
        paramVarArgs.f(5, this.path);
      }
      paramVarArgs.aY(6, this.TdQ);
      paramVarArgs.co(7, this.TUO);
      AppMethodBeat.o(123636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label604;
      }
    }
    label604:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.appid);
      }
      i += g.a.a.b.b.a.bM(4, this.TnH);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.path);
      }
      i = g.a.a.b.b.a.bM(6, this.TdQ);
      int j = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(123636);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dno localdno = (dno)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123636);
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
            localdno.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(123636);
          return 0;
        case 2: 
          localdno.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 3: 
          localdno.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 4: 
          localdno.TnH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123636);
          return 0;
        case 5: 
          localdno.path = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 6: 
          localdno.TdQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123636);
          return 0;
        }
        localdno.TUO = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(123636);
        return 0;
      }
      AppMethodBeat.o(123636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dno
 * JD-Core Version:    0.7.0.1
 */