package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdb
  extends dyl
{
  public String TkY;
  public String TkZ;
  public String appid;
  public String jDL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.TkY != null) {
        paramVarArgs.f(3, this.TkY);
      }
      if (this.jDL != null) {
        paramVarArgs.f(4, this.jDL);
      }
      if (this.TkZ != null) {
        paramVarArgs.f(5, this.TkZ);
      }
      AppMethodBeat.o(260408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label528;
      }
    }
    label528:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.TkY != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TkY);
      }
      paramInt = i;
      if (this.jDL != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jDL);
      }
      i = paramInt;
      if (this.TkZ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TkZ);
      }
      AppMethodBeat.o(260408);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(260408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cdb localcdb = (cdb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260408);
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
            localcdb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(260408);
          return 0;
        case 2: 
          localcdb.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(260408);
          return 0;
        case 3: 
          localcdb.TkY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(260408);
          return 0;
        case 4: 
          localcdb.jDL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(260408);
          return 0;
        }
        localcdb.TkZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(260408);
        return 0;
      }
      AppMethodBeat.o(260408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdb
 * JD-Core Version:    0.7.0.1
 */