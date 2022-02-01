package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ary
  extends com.tencent.mm.bw.a
{
  public int GIy;
  public String desc;
  public int drZ;
  public LinkedList<arx> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String ssR;
  public String username;
  
  public ary()
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
      if (this.ssR != null) {
        paramVarArgs.d(4, this.ssR);
      }
      if (this.desc != null) {
        paramVarArgs.d(5, this.desc);
      }
      paramVarArgs.aS(6, this.GIy);
      paramVarArgs.aS(7, this.drZ);
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
      if (this.ssR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ssR);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.desc);
      }
      i = i + f.a.a.b.b.a.bz(6, this.GIy) + f.a.a.b.b.a.bz(7, this.drZ) + f.a.a.a.c(8, 8, this.mediaList);
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
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(164047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ary localary = (ary)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164047);
          return -1;
        case 1: 
          localary.objectId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 2: 
          localary.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 3: 
          localary.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 4: 
          localary.ssR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 5: 
          localary.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 6: 
          localary.GIy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(164047);
          return 0;
        case 7: 
          localary.drZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(164047);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((arx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localary.mediaList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(164047);
          return 0;
        }
        localary.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(164047);
        return 0;
      }
      AppMethodBeat.o(164047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ary
 * JD-Core Version:    0.7.0.1
 */