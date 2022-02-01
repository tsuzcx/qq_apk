package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bx.a
{
  public String URL;
  public u acjj;
  public LinkedList<String> acjk;
  public String acjl;
  public long acjm;
  public w acjn;
  public long acjo;
  public int oOt;
  public String oOx;
  
  public v()
  {
    AppMethodBeat.i(259678);
    this.acjk = new LinkedList();
    AppMethodBeat.o(259678);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259684);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acjj != null)
      {
        paramVarArgs.qD(1, this.acjj.computeSize());
        this.acjj.writeFields(paramVarArgs);
      }
      if (this.oOx != null) {
        paramVarArgs.g(2, this.oOx);
      }
      paramVarArgs.e(3, 1, this.acjk);
      if (this.acjl != null) {
        paramVarArgs.g(4, this.acjl);
      }
      if (this.URL != null) {
        paramVarArgs.g(5, this.URL);
      }
      paramVarArgs.bv(6, this.acjm);
      if (this.acjn != null)
      {
        paramVarArgs.qD(7, this.acjn.computeSize());
        this.acjn.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.oOt);
      paramVarArgs.bv(9, this.acjo);
      AppMethodBeat.o(259684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acjj == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = i.a.a.a.qC(1, this.acjj.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oOx != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.oOx);
      }
      i += i.a.a.a.c(3, 1, this.acjk);
      paramInt = i;
      if (this.acjl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acjl);
      }
      i = paramInt;
      if (this.URL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.URL);
      }
      i += i.a.a.b.b.a.q(6, this.acjm);
      paramInt = i;
      if (this.acjn != null) {
        paramInt = i + i.a.a.a.qC(7, this.acjn.computeSize());
      }
      i = i.a.a.b.b.a.cJ(8, this.oOt);
      int j = i.a.a.b.b.a.q(9, this.acjo);
      AppMethodBeat.o(259684);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acjk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259684);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259684);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new u();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((u)localObject2).parseFrom((byte[])localObject1);
            }
            localv.acjj = ((u)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259684);
          return 0;
        case 2: 
          localv.oOx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259684);
          return 0;
        case 3: 
          localv.acjk.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(259684);
          return 0;
        case 4: 
          localv.acjl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259684);
          return 0;
        case 5: 
          localv.URL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259684);
          return 0;
        case 6: 
          localv.acjm = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259684);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new w();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((w)localObject2).parseFrom((byte[])localObject1);
            }
            localv.acjn = ((w)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259684);
          return 0;
        case 8: 
          localv.oOt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259684);
          return 0;
        }
        localv.acjo = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(259684);
        return 0;
      }
      AppMethodBeat.o(259684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.v
 * JD-Core Version:    0.7.0.1
 */