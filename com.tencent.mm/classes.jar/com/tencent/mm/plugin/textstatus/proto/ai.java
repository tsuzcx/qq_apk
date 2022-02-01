package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class ai
  extends dyl
{
  public String MEN;
  public int MFK;
  public String MFz;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243767);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MFz != null) {
        paramVarArgs.f(2, this.MFz);
      }
      if (this.MEN != null) {
        paramVarArgs.f(3, this.MEN);
      }
      if (this.username != null) {
        paramVarArgs.f(4, this.username);
      }
      paramVarArgs.aY(5, this.MFK);
      paramVarArgs.aY(6, this.type);
      AppMethodBeat.o(243767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label560;
      }
    }
    label560:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MFz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.MFz);
      }
      i = paramInt;
      if (this.MEN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MEN);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.username);
      }
      i = g.a.a.b.b.a.bM(5, this.MFK);
      int j = g.a.a.b.b.a.bM(6, this.type);
      AppMethodBeat.o(243767);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243767);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243767);
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
            localai.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(243767);
          return 0;
        case 2: 
          localai.MFz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243767);
          return 0;
        case 3: 
          localai.MEN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243767);
          return 0;
        case 4: 
          localai.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243767);
          return 0;
        case 5: 
          localai.MFK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243767);
          return 0;
        }
        localai.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(243767);
        return 0;
      }
      AppMethodBeat.o(243767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ai
 * JD-Core Version:    0.7.0.1
 */