package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aws
  extends com.tencent.mm.bw.a
{
  public int LHt;
  public LinkedList<FinderObject> LHu;
  public String desc;
  public String hwd;
  public long hwe;
  public String hwg;
  public String key;
  public long liveId;
  public String sessionBuffer;
  public FinderObject tuO;
  
  public aws()
  {
    AppMethodBeat.i(209543);
    this.LHu = new LinkedList();
    AppMethodBeat.o(209543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209544);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      paramVarArgs.bb(2, this.liveId);
      if (this.hwg != null) {
        paramVarArgs.e(3, this.hwg);
      }
      paramVarArgs.bb(4, this.hwe);
      if (this.hwd != null) {
        paramVarArgs.e(5, this.hwd);
      }
      if (this.desc != null) {
        paramVarArgs.e(6, this.desc);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.e(7, this.sessionBuffer);
      }
      if (this.tuO != null)
      {
        paramVarArgs.ni(8, this.tuO.computeSize());
        this.tuO.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.LHt);
      paramVarArgs.e(10, 8, this.LHu);
      AppMethodBeat.o(209544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = g.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.liveId);
      paramInt = i;
      if (this.hwg != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.hwg);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.hwe);
      paramInt = i;
      if (this.hwd != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.hwd);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.desc);
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.sessionBuffer);
      }
      i = paramInt;
      if (this.tuO != null) {
        i = paramInt + g.a.a.a.nh(8, this.tuO.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(9, this.LHt);
      int j = g.a.a.a.c(10, 8, this.LHu);
      AppMethodBeat.o(209544);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LHu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aws localaws = (aws)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209544);
          return -1;
        case 1: 
          localaws.key = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209544);
          return 0;
        case 2: 
          localaws.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209544);
          return 0;
        case 3: 
          localaws.hwg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209544);
          return 0;
        case 4: 
          localaws.hwe = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209544);
          return 0;
        case 5: 
          localaws.hwd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209544);
          return 0;
        case 6: 
          localaws.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209544);
          return 0;
        case 7: 
          localaws.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209544);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaws.tuO = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209544);
          return 0;
        case 9: 
          localaws.LHt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209544);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaws.LHu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209544);
        return 0;
      }
      AppMethodBeat.o(209544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aws
 * JD-Core Version:    0.7.0.1
 */