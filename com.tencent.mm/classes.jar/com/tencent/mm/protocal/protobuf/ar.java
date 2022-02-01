package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ar
  extends dyl
{
  public String RFj;
  public String RFk;
  public String cli_msg_id;
  public long klE;
  public String ktQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189101);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.klE);
      if (this.ktQ != null) {
        paramVarArgs.f(3, this.ktQ);
      }
      if (this.RFj != null) {
        paramVarArgs.f(4, this.RFj);
      }
      if (this.cli_msg_id != null) {
        paramVarArgs.f(5, this.cli_msg_id);
      }
      if (this.RFk != null) {
        paramVarArgs.f(6, this.RFk);
      }
      AppMethodBeat.o(189101);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.klE);
      paramInt = i;
      if (this.ktQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ktQ);
      }
      i = paramInt;
      if (this.RFj != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RFj);
      }
      paramInt = i;
      if (this.cli_msg_id != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.cli_msg_id);
      }
      i = paramInt;
      if (this.RFk != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RFk);
      }
      AppMethodBeat.o(189101);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(189101);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ar localar = (ar)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189101);
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
            localar.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(189101);
          return 0;
        case 2: 
          localar.klE = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(189101);
          return 0;
        case 3: 
          localar.ktQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(189101);
          return 0;
        case 4: 
          localar.RFj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(189101);
          return 0;
        case 5: 
          localar.cli_msg_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(189101);
          return 0;
        }
        localar.RFk = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(189101);
        return 0;
      }
      AppMethodBeat.o(189101);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ar
 * JD-Core Version:    0.7.0.1
 */