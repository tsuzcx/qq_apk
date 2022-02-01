package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dne
  extends dyl
{
  public String RFj;
  public b RLO;
  public String cli_msg_id;
  public String content;
  public long klE;
  public int msg_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200430);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLO != null) {
        paramVarArgs.c(2, this.RLO);
      }
      paramVarArgs.aY(3, this.msg_type);
      if (this.content != null) {
        paramVarArgs.f(4, this.content);
      }
      paramVarArgs.bm(5, this.klE);
      if (this.RFj != null) {
        paramVarArgs.f(6, this.RFj);
      }
      if (this.cli_msg_id != null) {
        paramVarArgs.f(7, this.cli_msg_id);
      }
      AppMethodBeat.o(200430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label620;
      }
    }
    label620:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLO != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RLO);
      }
      i += g.a.a.b.b.a.bM(3, this.msg_type);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.content);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.klE);
      paramInt = i;
      if (this.RFj != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RFj);
      }
      i = paramInt;
      if (this.cli_msg_id != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.cli_msg_id);
      }
      AppMethodBeat.o(200430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dne localdne = (dne)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200430);
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
            localdne.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(200430);
          return 0;
        case 2: 
          localdne.RLO = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(200430);
          return 0;
        case 3: 
          localdne.msg_type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(200430);
          return 0;
        case 4: 
          localdne.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200430);
          return 0;
        case 5: 
          localdne.klE = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(200430);
          return 0;
        case 6: 
          localdne.RFj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200430);
          return 0;
        }
        localdne.cli_msg_id = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(200430);
        return 0;
      }
      AppMethodBeat.o(200430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dne
 * JD-Core Version:    0.7.0.1
 */