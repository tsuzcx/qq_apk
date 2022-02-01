package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbv
  extends com.tencent.mm.bx.a
{
  public LinkedList<dbx> aaHo;
  public LinkedList<Integer> aaHp;
  public int scene;
  public String sessionId;
  
  public dbv()
  {
    AppMethodBeat.i(259468);
    this.aaHo = new LinkedList();
    this.aaHp = new LinkedList();
    AppMethodBeat.o(259468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.g(1, this.sessionId);
      }
      paramVarArgs.bS(2, this.scene);
      paramVarArgs.e(3, 8, this.aaHo);
      paramVarArgs.e(4, 2, this.aaHp);
      AppMethodBeat.o(259475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label439;
      }
    }
    label439:
    for (paramInt = i.a.a.b.b.a.h(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.scene);
      int j = i.a.a.a.c(3, 8, this.aaHo);
      int k = i.a.a.a.c(4, 2, this.aaHp);
      AppMethodBeat.o(259475);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaHo.clear();
        this.aaHp.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dbv localdbv = (dbv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259475);
          return -1;
        case 1: 
          localdbv.sessionId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259475);
          return 0;
        case 2: 
          localdbv.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259475);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dbx localdbx = new dbx();
            if ((localObject != null) && (localObject.length > 0)) {
              localdbx.parseFrom((byte[])localObject);
            }
            localdbv.aaHo.add(localdbx);
            paramInt += 1;
          }
          AppMethodBeat.o(259475);
          return 0;
        }
        localdbv.aaHp.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
        AppMethodBeat.o(259475);
        return 0;
      }
      AppMethodBeat.o(259475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbv
 * JD-Core Version:    0.7.0.1
 */