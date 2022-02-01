package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class flc
  extends com.tencent.mm.cd.a
{
  public LinkedList<fla> UJP;
  public boolean UJQ;
  public boolean UJR;
  public boolean UJS;
  public boolean UJT;
  public String appId;
  public String fIZ;
  public int kqZ;
  public long mhP;
  public String pHq;
  public String sNZ;
  public int svw;
  public String url;
  
  public flc()
  {
    AppMethodBeat.i(206702);
    this.UJP = new LinkedList();
    AppMethodBeat.o(206702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206706);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(206706);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      paramVarArgs.bm(2, this.mhP);
      paramVarArgs.co(3, this.UJQ);
      paramVarArgs.co(4, this.UJR);
      if (this.sNZ != null) {
        paramVarArgs.f(5, this.sNZ);
      }
      if (this.pHq != null) {
        paramVarArgs.f(6, this.pHq);
      }
      if (this.fIZ != null) {
        paramVarArgs.f(7, this.fIZ);
      }
      paramVarArgs.co(8, this.UJS);
      paramVarArgs.e(9, 8, this.UJP);
      paramVarArgs.aY(10, this.kqZ);
      paramVarArgs.aY(11, this.svw);
      if (this.appId != null) {
        paramVarArgs.f(12, this.appId);
      }
      paramVarArgs.co(13, this.UJT);
      AppMethodBeat.o(206706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label928;
      }
    }
    label928:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.mhP) + (g.a.a.b.b.a.gL(3) + 1) + (g.a.a.b.b.a.gL(4) + 1);
      paramInt = i;
      if (this.sNZ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.sNZ);
      }
      i = paramInt;
      if (this.pHq != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.pHq);
      }
      paramInt = i;
      if (this.fIZ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.fIZ);
      }
      i = paramInt + (g.a.a.b.b.a.gL(8) + 1) + g.a.a.a.c(9, 8, this.UJP) + g.a.a.b.b.a.bM(10, this.kqZ) + g.a.a.b.b.a.bM(11, this.svw);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.appId);
      }
      i = g.a.a.b.b.a.gL(13);
      AppMethodBeat.o(206706);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UJP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(206706);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206706);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        flc localflc = (flc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206706);
          return -1;
        case 1: 
          localflc.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(206706);
          return 0;
        case 2: 
          localflc.mhP = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(206706);
          return 0;
        case 3: 
          localflc.UJQ = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(206706);
          return 0;
        case 4: 
          localflc.UJR = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(206706);
          return 0;
        case 5: 
          localflc.sNZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(206706);
          return 0;
        case 6: 
          localflc.pHq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(206706);
          return 0;
        case 7: 
          localflc.fIZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(206706);
          return 0;
        case 8: 
          localflc.UJS = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(206706);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fla localfla = new fla();
            if ((localObject != null) && (localObject.length > 0)) {
              localfla.parseFrom((byte[])localObject);
            }
            localflc.UJP.add(localfla);
            paramInt += 1;
          }
          AppMethodBeat.o(206706);
          return 0;
        case 10: 
          localflc.kqZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(206706);
          return 0;
        case 11: 
          localflc.svw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(206706);
          return 0;
        case 12: 
          localflc.appId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(206706);
          return 0;
        }
        localflc.UJT = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(206706);
        return 0;
      }
      AppMethodBeat.o(206706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flc
 * JD-Core Version:    0.7.0.1
 */