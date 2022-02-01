package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcf
  extends com.tencent.mm.cd.a
{
  public String Eyy;
  public String Sba;
  public int TJF;
  public int TJG;
  public dvh TJH;
  public String desc;
  public String icon;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91555);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.Eyy != null) {
        paramVarArgs.f(3, this.Eyy);
      }
      paramVarArgs.aY(4, this.TJF);
      paramVarArgs.aY(5, this.TJG);
      if (this.Sba != null) {
        paramVarArgs.f(6, this.Sba);
      }
      if (this.icon != null) {
        paramVarArgs.f(7, this.icon);
      }
      if (this.TJH != null)
      {
        paramVarArgs.oE(8, this.TJH.computeSize());
        this.TJH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label680;
      }
    }
    label680:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.Eyy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Eyy);
      }
      i = i + g.a.a.b.b.a.bM(4, this.TJF) + g.a.a.b.b.a.bM(5, this.TJG);
      paramInt = i;
      if (this.Sba != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sba);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.icon);
      }
      paramInt = i;
      if (this.TJH != null) {
        paramInt = i + g.a.a.a.oD(8, this.TJH.computeSize());
      }
      AppMethodBeat.o(91555);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dcf localdcf = (dcf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91555);
          return -1;
        case 1: 
          localdcf.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 2: 
          localdcf.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 3: 
          localdcf.Eyy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 4: 
          localdcf.TJF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91555);
          return 0;
        case 5: 
          localdcf.TJG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91555);
          return 0;
        case 6: 
          localdcf.Sba = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 7: 
          localdcf.icon = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91555);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dvh localdvh = new dvh();
          if ((localObject != null) && (localObject.length > 0)) {
            localdvh.parseFrom((byte[])localObject);
          }
          localdcf.TJH = localdvh;
          paramInt += 1;
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      AppMethodBeat.o(91555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcf
 * JD-Core Version:    0.7.0.1
 */