package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ald
  extends com.tencent.mm.bx.a
{
  public int Dmx;
  public String desc;
  public int did;
  public LinkedList<alc> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String qDs;
  public String username;
  
  public ald()
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
      if (this.qDs != null) {
        paramVarArgs.d(4, this.qDs);
      }
      if (this.desc != null) {
        paramVarArgs.d(5, this.desc);
      }
      paramVarArgs.aR(6, this.Dmx);
      paramVarArgs.aR(7, this.did);
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
      if (this.qDs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.qDs);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.desc);
      }
      i = i + f.a.a.b.b.a.bA(6, this.Dmx) + f.a.a.b.b.a.bA(7, this.did) + f.a.a.a.c(8, 8, this.mediaList);
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
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(164047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ald localald = (ald)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164047);
          return -1;
        case 1: 
          localald.objectId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 2: 
          localald.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 3: 
          localald.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 4: 
          localald.qDs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 5: 
          localald.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 6: 
          localald.Dmx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(164047);
          return 0;
        case 7: 
          localald.did = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(164047);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((alc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localald.mediaList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(164047);
          return 0;
        }
        localald.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(164047);
        return 0;
      }
      AppMethodBeat.o(164047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ald
 * JD-Core Version:    0.7.0.1
 */