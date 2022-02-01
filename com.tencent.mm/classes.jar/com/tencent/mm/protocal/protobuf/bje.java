package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bje
  extends com.tencent.mm.cd.a
{
  public int ACQ;
  public String STp;
  public String STq;
  public String avatar;
  public String desc;
  public int fCa;
  public long localId;
  public LinkedList<bjc> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String username;
  
  public bje()
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.objectId != null) {
        paramVarArgs.f(1, this.objectId);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.f(3, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.f(4, this.avatar);
      }
      if (this.desc != null) {
        paramVarArgs.f(5, this.desc);
      }
      paramVarArgs.aY(6, this.ACQ);
      paramVarArgs.aY(7, this.fCa);
      paramVarArgs.e(8, 8, this.mediaList);
      if (this.objectNonceId != null) {
        paramVarArgs.f(9, this.objectNonceId);
      }
      paramVarArgs.bm(10, this.localId);
      if (this.STp != null) {
        paramVarArgs.f(11, this.STp);
      }
      if (this.STq != null) {
        paramVarArgs.f(12, this.STq);
      }
      AppMethodBeat.o(164047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.objectId == null) {
        break label896;
      }
    }
    label896:
    for (int i = g.a.a.b.b.a.g(1, this.objectId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.nickname);
      }
      paramInt = i;
      if (this.avatar != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.avatar);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.desc);
      }
      i = i + g.a.a.b.b.a.bM(6, this.ACQ) + g.a.a.b.b.a.bM(7, this.fCa) + g.a.a.a.c(8, 8, this.mediaList);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.p(10, this.localId);
      paramInt = i;
      if (this.STp != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.STp);
      }
      i = paramInt;
      if (this.STq != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.STq);
      }
      AppMethodBeat.o(164047);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mediaList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(164047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bje localbje = (bje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164047);
          return -1;
        case 1: 
          localbje.objectId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 2: 
          localbje.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 3: 
          localbje.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 4: 
          localbje.avatar = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 5: 
          localbje.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 6: 
          localbje.ACQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(164047);
          return 0;
        case 7: 
          localbje.fCa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(164047);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bjc localbjc = new bjc();
            if ((localObject != null) && (localObject.length > 0)) {
              localbjc.parseFrom((byte[])localObject);
            }
            localbje.mediaList.add(localbjc);
            paramInt += 1;
          }
          AppMethodBeat.o(164047);
          return 0;
        case 9: 
          localbje.objectNonceId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(164047);
          return 0;
        case 10: 
          localbje.localId = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(164047);
          return 0;
        case 11: 
          localbje.STp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(164047);
          return 0;
        }
        localbje.STq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(164047);
        return 0;
      }
      AppMethodBeat.o(164047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bje
 * JD-Core Version:    0.7.0.1
 */