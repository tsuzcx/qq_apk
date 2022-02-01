package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cen
  extends dyl
{
  public int RGT;
  public boolean Tme;
  public LinkedList<String> Tmf;
  public String appid;
  public int source;
  
  public cen()
  {
    AppMethodBeat.i(147765);
    this.Tmf = new LinkedList();
    AppMethodBeat.o(147765);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147766);
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
      paramVarArgs.co(3, this.Tme);
      paramVarArgs.e(4, 1, this.Tmf);
      paramVarArgs.aY(5, this.source);
      paramVarArgs.aY(6, this.RGT);
      AppMethodBeat.o(147766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label544;
      }
    }
    label544:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appid);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      int j = g.a.a.a.c(4, 1, this.Tmf);
      int k = g.a.a.b.b.a.bM(5, this.source);
      int m = g.a.a.b.b.a.bM(6, this.RGT);
      AppMethodBeat.o(147766);
      return i + (paramInt + 1) + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tmf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(147766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cen localcen = (cen)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147766);
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
            localcen.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(147766);
          return 0;
        case 2: 
          localcen.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(147766);
          return 0;
        case 3: 
          localcen.Tme = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(147766);
          return 0;
        case 4: 
          localcen.Tmf.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(147766);
          return 0;
        case 5: 
          localcen.source = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(147766);
          return 0;
        }
        localcen.RGT = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(147766);
        return 0;
      }
      AppMethodBeat.o(147766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cen
 * JD-Core Version:    0.7.0.1
 */