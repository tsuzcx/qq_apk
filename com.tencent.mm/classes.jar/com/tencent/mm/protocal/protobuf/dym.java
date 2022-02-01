package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dym
  extends dyl
{
  public int IfZ;
  public String Igm;
  public String Ign;
  public String RLA;
  public int RZy;
  public String TNB;
  public int UdW;
  public String UdX;
  public int UdY;
  public int UdZ;
  public b Uea;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72581);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Igm != null) {
        paramVarArgs.f(2, this.Igm);
      }
      if (this.Ign != null) {
        paramVarArgs.f(3, this.Ign);
      }
      if (this.fvP != null) {
        paramVarArgs.f(4, this.fvP);
      }
      paramVarArgs.aY(5, this.IfZ);
      paramVarArgs.aY(6, this.UdW);
      if (this.UdX != null) {
        paramVarArgs.f(7, this.UdX);
      }
      paramVarArgs.aY(8, this.UdY);
      paramVarArgs.aY(9, this.UdZ);
      if (this.RLA != null) {
        paramVarArgs.f(10, this.RLA);
      }
      if (this.TNB != null) {
        paramVarArgs.f(11, this.TNB);
      }
      if (this.Uea != null) {
        paramVarArgs.c(12, this.Uea);
      }
      paramVarArgs.aY(13, this.RZy);
      AppMethodBeat.o(72581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label940;
      }
    }
    label940:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Igm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Igm);
      }
      i = paramInt;
      if (this.Ign != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ign);
      }
      paramInt = i;
      if (this.fvP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fvP);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.IfZ) + g.a.a.b.b.a.bM(6, this.UdW);
      paramInt = i;
      if (this.UdX != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UdX);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.UdY) + g.a.a.b.b.a.bM(9, this.UdZ);
      paramInt = i;
      if (this.RLA != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RLA);
      }
      i = paramInt;
      if (this.TNB != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.TNB);
      }
      paramInt = i;
      if (this.Uea != null) {
        paramInt = i + g.a.a.b.b.a.b(12, this.Uea);
      }
      i = g.a.a.b.b.a.bM(13, this.RZy);
      AppMethodBeat.o(72581);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dym localdym = (dym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72581);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdym.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72581);
          return 0;
        case 2: 
          localdym.Igm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 3: 
          localdym.Ign = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 4: 
          localdym.fvP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 5: 
          localdym.IfZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72581);
          return 0;
        case 6: 
          localdym.UdW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72581);
          return 0;
        case 7: 
          localdym.UdX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 8: 
          localdym.UdY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72581);
          return 0;
        case 9: 
          localdym.UdZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72581);
          return 0;
        case 10: 
          localdym.RLA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 11: 
          localdym.TNB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72581);
          return 0;
        case 12: 
          localdym.Uea = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(72581);
          return 0;
        }
        localdym.RZy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72581);
        return 0;
      }
      AppMethodBeat.o(72581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dym
 * JD-Core Version:    0.7.0.1
 */