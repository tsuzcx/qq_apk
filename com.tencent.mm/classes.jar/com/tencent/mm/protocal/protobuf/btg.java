package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btg
  extends com.tencent.mm.bx.a
{
  public LinkedList<bfl> ZKa;
  public long aabc;
  public long aabd;
  public String username;
  
  public btg()
  {
    AppMethodBeat.i(259495);
    this.ZKa = new LinkedList();
    AppMethodBeat.o(259495);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259502);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.e(2, 8, this.ZKa);
      paramVarArgs.bv(3, this.aabc);
      paramVarArgs.bv(4, this.aabd);
      AppMethodBeat.o(259502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label424;
      }
    }
    label424:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.ZKa);
      int j = i.a.a.b.b.a.q(3, this.aabc);
      int k = i.a.a.b.b.a.q(4, this.aabd);
      AppMethodBeat.o(259502);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZKa.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        btg localbtg = (btg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259502);
          return -1;
        case 1: 
          localbtg.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259502);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bfl localbfl = new bfl();
            if ((localObject != null) && (localObject.length > 0)) {
              localbfl.parseFrom((byte[])localObject);
            }
            localbtg.ZKa.add(localbfl);
            paramInt += 1;
          }
          AppMethodBeat.o(259502);
          return 0;
        case 3: 
          localbtg.aabc = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259502);
          return 0;
        }
        localbtg.aabd = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259502);
        return 0;
      }
      AppMethodBeat.o(259502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btg
 * JD-Core Version:    0.7.0.1
 */