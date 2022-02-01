package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zk
  extends com.tencent.mm.cd.a
{
  public coi Phd;
  public coi Phe;
  public String RZB;
  public String SlI;
  public int SlJ;
  public String title;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177332);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.Phd != null)
      {
        paramVarArgs.oE(3, this.Phd.computeSize());
        this.Phd.writeFields(paramVarArgs);
      }
      if (this.Phe != null)
      {
        paramVarArgs.oE(4, this.Phe.computeSize());
        this.Phe.writeFields(paramVarArgs);
      }
      if (this.SlI != null) {
        paramVarArgs.f(5, this.SlI);
      }
      if (this.RZB != null) {
        paramVarArgs.f(6, this.RZB);
      }
      paramVarArgs.aY(7, this.SlJ);
      AppMethodBeat.o(177332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label710;
      }
    }
    label710:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.Phd != null) {
        i = paramInt + g.a.a.a.oD(3, this.Phd.computeSize());
      }
      paramInt = i;
      if (this.Phe != null) {
        paramInt = i + g.a.a.a.oD(4, this.Phe.computeSize());
      }
      i = paramInt;
      if (this.SlI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SlI);
      }
      paramInt = i;
      if (this.RZB != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RZB);
      }
      i = g.a.a.b.b.a.bM(7, this.SlJ);
      AppMethodBeat.o(177332);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(177332);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        zk localzk = (zk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        coi localcoi;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(177332);
          return -1;
        case 1: 
          localzk.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 2: 
          localzk.wording = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localcoi = new coi();
            if ((localObject != null) && (localObject.length > 0)) {
              localcoi.parseFrom((byte[])localObject);
            }
            localzk.Phd = localcoi;
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localcoi = new coi();
            if ((localObject != null) && (localObject.length > 0)) {
              localcoi.parseFrom((byte[])localObject);
            }
            localzk.Phe = localcoi;
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 5: 
          localzk.SlI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 6: 
          localzk.RZB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(177332);
          return 0;
        }
        localzk.SlJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(177332);
        return 0;
      }
      AppMethodBeat.o(177332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zk
 * JD-Core Version:    0.7.0.1
 */