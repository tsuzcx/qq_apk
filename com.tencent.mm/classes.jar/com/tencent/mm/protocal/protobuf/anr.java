package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anr
  extends com.tencent.mm.cd.a
{
  public String SAm;
  public LinkedList<String> SAn;
  public String appId;
  public String desc;
  public String fLi;
  public aoc fRz;
  public String fuO;
  public String title;
  public int type;
  
  public anr()
  {
    AppMethodBeat.i(127463);
    this.SAn = new LinkedList();
    AppMethodBeat.o(127463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127464);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.fLi != null) {
        paramVarArgs.f(3, this.fLi);
      }
      if (this.SAm != null) {
        paramVarArgs.f(4, this.SAm);
      }
      if (this.appId != null) {
        paramVarArgs.f(5, this.appId);
      }
      if (this.fuO != null) {
        paramVarArgs.f(6, this.fuO);
      }
      paramVarArgs.e(7, 1, this.SAn);
      paramVarArgs.aY(8, this.type);
      if (this.fRz != null)
      {
        paramVarArgs.oE(9, this.fRz.computeSize());
        this.fRz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label756;
      }
    }
    label756:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.fLi != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fLi);
      }
      paramInt = i;
      if (this.SAm != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SAm);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.appId);
      }
      paramInt = i;
      if (this.fuO != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fuO);
      }
      i = paramInt + g.a.a.a.c(7, 1, this.SAn) + g.a.a.b.b.a.bM(8, this.type);
      paramInt = i;
      if (this.fRz != null) {
        paramInt = i + g.a.a.a.oD(9, this.fRz.computeSize());
      }
      AppMethodBeat.o(127464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SAn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        anr localanr = (anr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127464);
          return -1;
        case 1: 
          localanr.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 2: 
          localanr.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 3: 
          localanr.fLi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 4: 
          localanr.SAm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 5: 
          localanr.appId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 6: 
          localanr.fuO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 7: 
          localanr.SAn.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(127464);
          return 0;
        case 8: 
          localanr.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127464);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aoc localaoc = new aoc();
          if ((localObject != null) && (localObject.length > 0)) {
            localaoc.parseFrom((byte[])localObject);
          }
          localanr.fRz = localaoc;
          paramInt += 1;
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      AppMethodBeat.o(127464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anr
 * JD-Core Version:    0.7.0.1
 */