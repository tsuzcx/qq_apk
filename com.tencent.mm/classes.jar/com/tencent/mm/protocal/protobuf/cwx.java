package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwx
  extends com.tencent.mm.cd.a
{
  public String Jyf;
  public String TFx;
  public String avatar;
  public String desc;
  public int fCa;
  public LinkedList<cww> mediaList;
  public String nickname;
  public String objectId;
  public String objectNonceId;
  public String username;
  
  public cwx()
  {
    AppMethodBeat.i(205974);
    this.mediaList = new LinkedList();
    AppMethodBeat.o(205974);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205978);
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
      paramVarArgs.aY(6, this.fCa);
      paramVarArgs.e(7, 8, this.mediaList);
      if (this.objectNonceId != null) {
        paramVarArgs.f(8, this.objectNonceId);
      }
      if (this.TFx != null) {
        paramVarArgs.f(9, this.TFx);
      }
      if (this.Jyf != null) {
        paramVarArgs.f(10, this.Jyf);
      }
      AppMethodBeat.o(205978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.objectId == null) {
        break label808;
      }
    }
    label808:
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
      i = i + g.a.a.b.b.a.bM(6, this.fCa) + g.a.a.a.c(7, 8, this.mediaList);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.TFx != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TFx);
      }
      paramInt = i;
      if (this.Jyf != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Jyf);
      }
      AppMethodBeat.o(205978);
      return paramInt;
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
        AppMethodBeat.o(205978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cwx localcwx = (cwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205978);
          return -1;
        case 1: 
          localcwx.objectId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205978);
          return 0;
        case 2: 
          localcwx.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205978);
          return 0;
        case 3: 
          localcwx.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205978);
          return 0;
        case 4: 
          localcwx.avatar = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205978);
          return 0;
        case 5: 
          localcwx.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205978);
          return 0;
        case 6: 
          localcwx.fCa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205978);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cww localcww = new cww();
            if ((localObject != null) && (localObject.length > 0)) {
              localcww.parseFrom((byte[])localObject);
            }
            localcwx.mediaList.add(localcww);
            paramInt += 1;
          }
          AppMethodBeat.o(205978);
          return 0;
        case 8: 
          localcwx.objectNonceId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205978);
          return 0;
        case 9: 
          localcwx.TFx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205978);
          return 0;
        }
        localcwx.Jyf = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(205978);
        return 0;
      }
      AppMethodBeat.o(205978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwx
 * JD-Core Version:    0.7.0.1
 */