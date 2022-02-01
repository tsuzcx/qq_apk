package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anx
  extends com.tencent.mm.bw.a
{
  public int EGJ;
  public String desc;
  public int dfy;
  public LinkedList<anw> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String ruB;
  public String username;
  
  public anx()
  {
    AppMethodBeat.i(164046);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(164046);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164047);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.objectId != null) {
        paramVarArgs.d(1, this.objectId);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.ruB != null) {
        paramVarArgs.d(4, this.ruB);
      }
      if (this.desc != null) {
        paramVarArgs.d(5, this.desc);
      }
      paramVarArgs.aR(6, this.EGJ);
      paramVarArgs.aR(7, this.dfy);
      paramVarArgs.e(8, 8, this.mediaList);
      if (this.objectNonceId != null) {
        paramVarArgs.d(9, this.objectNonceId);
      }
      AppMethodBeat.o(164047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.objectId == null) {
        break label750;
      }
    }
    label750:
    for (int i = f.a.a.b.b.a.e(1, this.objectId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.ruB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ruB);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.desc);
      }
      i = i + f.a.a.b.b.a.bx(6, this.EGJ) + f.a.a.b.b.a.bx(7, this.dfy) + f.a.a.a.c(8, 8, this.mediaList);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.objectNonceId);
      }
      AppMethodBeat.o(164047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(164047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anx localanx = (anx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164047);
          return -1;
        case 1: 
          localanx.objectId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 2: 
          localanx.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 3: 
          localanx.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 4: 
          localanx.ruB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 5: 
          localanx.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 6: 
          localanx.EGJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(164047);
          return 0;
        case 7: 
          localanx.dfy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(164047);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((anw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanx.mediaList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(164047);
          return 0;
        }
        localanx.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(164047);
        return 0;
      }
      AppMethodBeat.o(164047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anx
 * JD-Core Version:    0.7.0.1
 */