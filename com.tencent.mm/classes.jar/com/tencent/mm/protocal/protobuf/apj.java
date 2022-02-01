package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class apj
  extends com.tencent.mm.bx.a
{
  public String Zwg;
  public String Zws;
  public LinkedList<String> Zwt;
  public boolean Zwu;
  public int Zwv;
  public dgc Zww;
  public boolean Zwx;
  
  public apj()
  {
    AppMethodBeat.i(32203);
    this.Zwt = new LinkedList();
    AppMethodBeat.o(32203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32204);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zwg == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32204);
        throw paramVarArgs;
      }
      if (this.Zwg != null) {
        paramVarArgs.g(1, this.Zwg);
      }
      if (this.Zws != null) {
        paramVarArgs.g(2, this.Zws);
      }
      paramVarArgs.e(3, 1, this.Zwt);
      paramVarArgs.di(4, this.Zwu);
      paramVarArgs.bS(5, this.Zwv);
      if (this.Zww != null)
      {
        paramVarArgs.qD(6, this.Zww.computeSize());
        this.Zww.writeFields(paramVarArgs);
      }
      paramVarArgs.di(7, this.Zwx);
      AppMethodBeat.o(32204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zwg == null) {
        break label657;
      }
    }
    label657:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zwg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zws != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zws);
      }
      i = i + i.a.a.a.c(3, 1, this.Zwt) + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.b.b.a.cJ(5, this.Zwv);
      paramInt = i;
      if (this.Zww != null) {
        paramInt = i + i.a.a.a.qC(6, this.Zww.computeSize());
      }
      i = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(32204);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zwt.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Zwg == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(32204);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32204);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        apj localapj = (apj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32204);
          return -1;
        case 1: 
          localapj.Zwg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 2: 
          localapj.Zws = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 3: 
          localapj.Zwt.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(32204);
          return 0;
        case 4: 
          localapj.Zwu = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(32204);
          return 0;
        case 5: 
          localapj.Zwv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32204);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dgc localdgc = new dgc();
            if ((localObject != null) && (localObject.length > 0)) {
              localdgc.parseFrom((byte[])localObject);
            }
            localapj.Zww = localdgc;
            paramInt += 1;
          }
          AppMethodBeat.o(32204);
          return 0;
        }
        localapj.Zwx = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(32204);
        return 0;
      }
      AppMethodBeat.o(32204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apj
 * JD-Core Version:    0.7.0.1
 */