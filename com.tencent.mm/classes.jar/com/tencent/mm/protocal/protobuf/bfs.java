package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfs
  extends com.tencent.mm.bx.a
{
  public long ZOv;
  public String ZPA;
  public int ZPB;
  public LinkedList<edv> ZPC;
  public long ZPD;
  public int result;
  public int status;
  
  public bfs()
  {
    AppMethodBeat.i(258386);
    this.ZPC = new LinkedList();
    AppMethodBeat.o(258386);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258388);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZPA != null) {
        paramVarArgs.g(1, this.ZPA);
      }
      paramVarArgs.bv(2, this.ZOv);
      paramVarArgs.bS(3, this.status);
      paramVarArgs.bS(4, this.ZPB);
      paramVarArgs.e(6, 8, this.ZPC);
      paramVarArgs.bS(7, this.result);
      paramVarArgs.bv(8, this.ZPD);
      AppMethodBeat.o(258388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZPA == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZPA) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.ZOv);
      int j = i.a.a.b.b.a.cJ(3, this.status);
      int k = i.a.a.b.b.a.cJ(4, this.ZPB);
      int m = i.a.a.a.c(6, 8, this.ZPC);
      int n = i.a.a.b.b.a.cJ(7, this.result);
      int i1 = i.a.a.b.b.a.q(8, this.ZPD);
      AppMethodBeat.o(258388);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZPC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bfs localbfs = (bfs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(258388);
          return -1;
        case 1: 
          localbfs.ZPA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258388);
          return 0;
        case 2: 
          localbfs.ZOv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258388);
          return 0;
        case 3: 
          localbfs.status = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258388);
          return 0;
        case 4: 
          localbfs.ZPB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258388);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            edv localedv = new edv();
            if ((localObject != null) && (localObject.length > 0)) {
              localedv.parseFrom((byte[])localObject);
            }
            localbfs.ZPC.add(localedv);
            paramInt += 1;
          }
          AppMethodBeat.o(258388);
          return 0;
        case 7: 
          localbfs.result = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258388);
          return 0;
        }
        localbfs.ZPD = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258388);
        return 0;
      }
      AppMethodBeat.o(258388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfs
 * JD-Core Version:    0.7.0.1
 */