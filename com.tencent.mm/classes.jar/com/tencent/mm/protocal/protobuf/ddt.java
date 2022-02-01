package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddt
  extends com.tencent.mm.cd.a
{
  public int OvV;
  public String OvX;
  public String OvY;
  public String OvZ;
  public String Owa;
  public String Owb;
  public String Owc;
  public int OxL;
  public ddu TLl;
  public String TLm;
  public String TLn;
  public int TLo;
  public String TLp;
  public String TLq;
  public String TLr;
  public String TLs;
  public String TLt;
  public String TLu;
  public String background_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72526);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.OxL);
      if (this.TLl != null)
      {
        paramVarArgs.oE(2, this.TLl.computeSize());
        this.TLl.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.OvV);
      if (this.OvX != null) {
        paramVarArgs.f(4, this.OvX);
      }
      if (this.OvY != null) {
        paramVarArgs.f(5, this.OvY);
      }
      if (this.OvZ != null) {
        paramVarArgs.f(6, this.OvZ);
      }
      if (this.Owa != null) {
        paramVarArgs.f(7, this.Owa);
      }
      if (this.Owb != null) {
        paramVarArgs.f(8, this.Owb);
      }
      if (this.Owc != null) {
        paramVarArgs.f(9, this.Owc);
      }
      if (this.background_color != null) {
        paramVarArgs.f(10, this.background_color);
      }
      if (this.TLm != null) {
        paramVarArgs.f(11, this.TLm);
      }
      if (this.TLn != null) {
        paramVarArgs.f(12, this.TLn);
      }
      paramVarArgs.aY(13, this.TLo);
      if (this.TLp != null) {
        paramVarArgs.f(14, this.TLp);
      }
      if (this.TLq != null) {
        paramVarArgs.f(15, this.TLq);
      }
      if (this.TLr != null) {
        paramVarArgs.f(16, this.TLr);
      }
      if (this.TLs != null) {
        paramVarArgs.f(17, this.TLs);
      }
      if (this.TLt != null) {
        paramVarArgs.f(18, this.TLt);
      }
      if (this.TLu != null) {
        paramVarArgs.f(19, this.TLu);
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.OxL) + 0;
      paramInt = i;
      if (this.TLl != null) {
        paramInt = i + g.a.a.a.oD(2, this.TLl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.OvV);
      paramInt = i;
      if (this.OvX != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.OvX);
      }
      i = paramInt;
      if (this.OvY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.OvY);
      }
      paramInt = i;
      if (this.OvZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.OvZ);
      }
      i = paramInt;
      if (this.Owa != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Owa);
      }
      paramInt = i;
      if (this.Owb != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Owb);
      }
      i = paramInt;
      if (this.Owc != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Owc);
      }
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.background_color);
      }
      i = paramInt;
      if (this.TLm != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.TLm);
      }
      paramInt = i;
      if (this.TLn != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TLn);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.TLo);
      paramInt = i;
      if (this.TLp != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.TLp);
      }
      i = paramInt;
      if (this.TLq != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.TLq);
      }
      paramInt = i;
      if (this.TLr != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.TLr);
      }
      i = paramInt;
      if (this.TLs != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.TLs);
      }
      paramInt = i;
      if (this.TLt != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.TLt);
      }
      i = paramInt;
      if (this.TLu != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.TLu);
      }
      AppMethodBeat.o(72526);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ddt localddt = (ddt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72526);
        return -1;
      case 1: 
        localddt.OxL = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72526);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ddu localddu = new ddu();
          if ((localObject != null) && (localObject.length > 0)) {
            localddu.parseFrom((byte[])localObject);
          }
          localddt.TLl = localddu;
          paramInt += 1;
        }
        AppMethodBeat.o(72526);
        return 0;
      case 3: 
        localddt.OvV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72526);
        return 0;
      case 4: 
        localddt.OvX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 5: 
        localddt.OvY = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 6: 
        localddt.OvZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 7: 
        localddt.Owa = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 8: 
        localddt.Owb = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 9: 
        localddt.Owc = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 10: 
        localddt.background_color = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 11: 
        localddt.TLm = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 12: 
        localddt.TLn = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 13: 
        localddt.TLo = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72526);
        return 0;
      case 14: 
        localddt.TLp = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 15: 
        localddt.TLq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 16: 
        localddt.TLr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 17: 
        localddt.TLs = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 18: 
        localddt.TLt = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72526);
        return 0;
      }
      localddt.TLu = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(72526);
      return 0;
    }
    AppMethodBeat.o(72526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddt
 * JD-Core Version:    0.7.0.1
 */