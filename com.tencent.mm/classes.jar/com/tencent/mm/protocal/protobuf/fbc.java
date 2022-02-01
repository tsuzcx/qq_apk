package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbc
  extends com.tencent.mm.cd.a
{
  public LinkedList<fbd> SiG;
  public String TVS;
  public int UtO;
  public String appid;
  public int version;
  public String wording;
  
  public fbc()
  {
    AppMethodBeat.i(176154);
    this.SiG = new LinkedList();
    AppMethodBeat.o(176154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176155);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SiG);
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      paramVarArgs.aY(3, this.UtO);
      if (this.TVS != null) {
        paramVarArgs.f(4, this.TVS);
      }
      if (this.appid != null) {
        paramVarArgs.f(5, this.appid);
      }
      paramVarArgs.aY(6, this.version);
      AppMethodBeat.o(176155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.SiG) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.UtO);
      paramInt = i;
      if (this.TVS != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TVS);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.appid);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.version);
      AppMethodBeat.o(176155);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SiG.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(176155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fbc localfbc = (fbc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176155);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fbd localfbd = new fbd();
          if ((localObject != null) && (localObject.length > 0)) {
            localfbd.parseFrom((byte[])localObject);
          }
          localfbc.SiG.add(localfbd);
          paramInt += 1;
        }
        AppMethodBeat.o(176155);
        return 0;
      case 2: 
        localfbc.wording = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 3: 
        localfbc.UtO = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(176155);
        return 0;
      case 4: 
        localfbc.TVS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 5: 
        localfbc.appid = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(176155);
        return 0;
      }
      localfbc.version = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(176155);
      return 0;
    }
    AppMethodBeat.o(176155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbc
 * JD-Core Version:    0.7.0.1
 */