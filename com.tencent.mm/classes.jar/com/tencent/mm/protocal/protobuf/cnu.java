package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnu
  extends dyl
{
  public String RDj;
  public String TcY;
  public String Tuh;
  public String appid;
  public int dXr;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90969);
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
      if (this.RDj != null) {
        paramVarArgs.f(3, this.RDj);
      }
      if (this.signature != null) {
        paramVarArgs.f(4, this.signature);
      }
      paramVarArgs.aY(5, this.dXr);
      if (this.Tuh != null) {
        paramVarArgs.f(6, this.Tuh);
      }
      if (this.TcY != null) {
        paramVarArgs.f(7, this.TcY);
      }
      AppMethodBeat.o(90969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.RDj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RDj);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.signature);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.dXr);
      paramInt = i;
      if (this.Tuh != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tuh);
      }
      i = paramInt;
      if (this.TcY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TcY);
      }
      AppMethodBeat.o(90969);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(90969);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cnu localcnu = (cnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90969);
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
            localcnu.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(90969);
          return 0;
        case 2: 
          localcnu.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 3: 
          localcnu.RDj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 4: 
          localcnu.signature = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(90969);
          return 0;
        case 5: 
          localcnu.dXr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(90969);
          return 0;
        case 6: 
          localcnu.Tuh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(90969);
          return 0;
        }
        localcnu.TcY = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(90969);
        return 0;
      }
      AppMethodBeat.o(90969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnu
 * JD-Core Version:    0.7.0.1
 */